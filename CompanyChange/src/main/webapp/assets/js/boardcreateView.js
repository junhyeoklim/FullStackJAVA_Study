$(document).ready(function() {
    var isFormModified = false;
    var fileList = [];
    var contextPath = $('#contextPath').text(); // contextPath 설정

    $('#summernote').summernote({
        height: 300,
        callbacks: {
            onImageUpload: function(files) {
                for (var i = 0; i < files.length; i++) {
                    sendImage(files[i]);
                }
            },
            onChange: function(contents, $editable) {
                isFormModified = true;
            }
        },
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'underline', 'clear']],
            ['fontsize', ['fontsize']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['table', ['table']],
            ['insert', ['link', 'picture', 'video', 'file']],
            ['view', ['fullscreen', 'codeview', 'help']]
        ]
    });

    $("#title").on('input', function() {
        isFormModified = true;
    });

    $("#fileSelectButton").on('click', function() {
        $("#fileAttachment").click();
    });

    $("#fileAttachment").on('change', function() {
        var files = $(this)[0].files;
        for (var i = 0; i < files.length; i++) {
            fileList.push(files[i]);
        }
        updateFileCount();
        displayFileList();
        $(this).val('');
    });

    function updateFileCount() {
        var fileCountText = fileList.length > 0 ? `선택된 파일: ${fileList.length}개` : '선택된 파일 없음';
        $("#fileCount").text(fileCountText);
    }

    function displayFileList() {
        var fileListContainer = $("#fileList");
        fileListContainer.empty();
        if (fileList.length > 0) {
            fileListContainer.show();
            fileListContainer.append(`
                <div class="file-header">
                    <button type="button" class="btn btn-danger btn-sm remove-all-files">x</button>
                    <span class="file-info">파일명</span>
                    <span class="file-size">용량</span>
                </div>
            `);
            fileList.forEach(function(file, index) {
                var fileSize = formatFileSize(file.size);
                var fileItem = `
                    <div class="file-item d-flex justify-content-between align-items-center mt-2">
                        <div class="d-flex align-items-center">
                            <button type="button" class="btn btn-danger btn-sm remove-file mr-2" data-index="${index}">x</button>
                            <span class="file-info">${file.name}</span>
                        </div>
                        <span class="file-size">${fileSize}</span>
                    </div>
                `;
                fileListContainer.append(fileItem);
            });
        } else {
            fileListContainer.hide();
        }
    }

    function formatFileSize(size) {
        var i = Math.floor(Math.log(size) / Math.log(1024));
        return (size / Math.pow(1024, i)).toFixed(2) * 1 + ' ' + ['B', 'KB', 'MB', 'GB', 'TB'][i];
    }

    $(document).on('click', '.remove-file', function() {
        var index = $(this).data('index');
        fileList.splice(index, 1);
        updateFileCount();
        displayFileList();
    });

    $(document).on('click', '.remove-all-files', function() {
        fileList = [];
        updateFileCount();
        displayFileList();
    });

    function sendImage(file) {
        var data = new FormData();
        data.append('file', file);
        data.append('category', 'normal');
        $.ajax({
            url: contextPath + '/uploadImage.do', // 변경된 경로
            type: 'POST',
            data: data,
            contentType: false,
            processData: false,
            success: function(url) {
                var range = $('#summernote').summernote('createRange');
                range.pasteHTML('<br>');
                $('#summernote').summernote('insertImage', url);
            },
            error: function(data) {
                console.log(data);
            }
        });
    }

    $('#submit').on('click', function(e) {
        e.preventDefault();

        var title = $('#title').val();
        var content = $('#summernote').summernote('code');

        // 첫 번째 이미지 태그를 찾고 그 앞에 <br> 태그를 추가하는 부분
        var contentWithBreak = content.replace(/(<img[^>]*>)/, function(match, imgTag) {
            return '<br>' + imgTag;
        });

        var is_notice = $('#is_notice').is(':checked') ? 'true' : 'false';

        if (title === "" || $('#summernote').summernote('isEmpty')) {
            if (title === "") {
                alert("제목을 입력해주세요.");
                $("#title").focus();
            } else if ($('#summernote').summernote('isEmpty')) {
                alert("내용을 입력해주세요.");
                $('#summernote').summernote('focus');
            }
            return false; // 폼 제출 방지
        }

        isFormModified = false; // 폼이 제출된 후에는 경고 창을 표시하지 않음

        $.ajax({
            type: 'POST',
            url: contextPath + '/insertBoard.do', // 변경된 경로
            data: {
                title: title,
                content: contentWithBreak,
                is_notice: is_notice
            },
            success: function(response) {
                console.log("Post data submitted successfully");

                // JSON 응답에서 b_id 추출
                var b_id = response.b_id;

                var formData = new FormData();
                formData.append('b_id', b_id);
                formData.append('is_notice', is_notice);
                fileList.forEach(function(file) {
                    formData.append('fileAttachment', file);
                    console.log("File to be uploaded: " + file.name);
                });

                // 파일 업로드
                $.ajax({
                    type: 'POST',
                    url: contextPath + '/uploadFiles.do', // 변경된 경로
                    data: formData,
                    contentType: false,
                    processData: false,
                    success: function(response) {
                        console.log("Files uploaded successfully");
                        window.location.href = contextPath + '/getBoardList.do';
                    },
                    error: function(xhr, status, error) {
                        console.log("Error uploading files: " + error);
                        alert('파일 업로드에 실패했습니다: ' + error);
                    }
                });
            },
            error: function(xhr, status, error) {
                console.log("Error submitting post: " + error);
                alert('게시글 작성에 실패했습니다: ' + error);
            }
        });
    });

    // Warn user if they attempt to leave the page with unsaved changes
    window.onbeforeunload = function(e) {
        if (isFormModified) {
            var confirmationMessage = '작성중인 내용이 있습니다. 정말 다른 메뉴로 이동하겠습니까?';
            (e || window.event).returnValue = confirmationMessage;
            return confirmationMessage;
        }
    };
});
