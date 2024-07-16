$(document).ready(function() {
    var isFormModified = false;
    var fileList = [];
    var existingFilesCount = $('#fileList .file-item').length;

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

    var content = $('#content').text();
    $('#summernote').summernote('code', content);

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
        var totalFilesCount = fileList.length + existingFilesCount;
        var fileCountText = totalFilesCount > 0 ? `선택된 파일: ${totalFilesCount}개` : '선택된 파일 없음';
        $("#fileCount").text(fileCountText);
    }

    function displayFileList() {
        var fileListContainer = $("#fileList");
        fileListContainer.empty();
        if (fileList.length > 0 || existingFilesCount > 0) {
            fileListContainer.show();
            fileListContainer.append(`
                <div class="file-header">
                    <button type="button" class="btn btn-danger btn-sm remove-all-files">x</button>
                    <span class="file-info">파일명</span>
                    <span class="file-size-header">용량</span>
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
            $('#fileList .existing-file-size').each(function() {
                var filePath = $(this).data('filepath');
                fetchFileSize(filePath, $(this));
            });
        }
    }

    function formatFileSize(size) {
        var i = Math.floor(Math.log(size) / Math.log(1024));
        return (size / Math.pow(1024, i)).toFixed(2) * 1 + ' ' + ['B', 'KB', 'MB', 'GB', 'TB'][i];
    }

    function fetchFileSize(filePath, element) {
        $.ajax({
            url: '/Company/GetFileSizeController',
            type: 'POST',
            data: { filePath: filePath },
            success: function(size) {
                element.text(formatFileSize(size));
            },
            error: function(xhr, status, error) {
                console.log("Error fetching file size: " + error);
                element.text('알 수 없음');
            }
        });
    }

    $('#fileList .existing-file-size').each(function() {
        var filePath = $(this).data('filepath');
        fetchFileSize(filePath, $(this));
    });

    $(document).on('click', '.remove-file', function() {
        var index = $(this).data('index');
        fileList.splice(index, 1);
        $(this).closest('.file-item').remove();
        existingFilesCount--;
        updateFileCount();
        displayFileList();
    });

    $(document).on('click', '.remove-all-files', function() {
        fileList = [];
        existingFilesCount = 0;
        $('#fileList').empty();
        updateFileCount();
    });

    function sendImage(file) {
        var data = new FormData();
        data.append('file', file);
        data.append('category', 'normal');
        $.ajax({
            url: '/Company/UploadImageController',
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
        var is_notice = $('#is_notice').is(':checked') ? 'true' : 'false';
        var b_id = $('#b_id').val();

        if (title === "" || $('#summernote').summernote('isEmpty')) {
            if (title === "") {
                alert("제목을 입력해주세요.");
                $("#title").focus();
            } else if ($('#summernote').summernote('isEmpty')) {
                alert("내용을 입력해주세요.");
                $('#summernote').summernote('focus');
            }
            return false;
        }

        isFormModified = false;

        $.ajax({
            type: 'POST',
            url: '/Company/UpdatePost.board',
            data: {
                b_id: b_id,
                title: title,
                content: content,
                is_notice: is_notice
            },
            success: function(response) {
                var formData = new FormData();
                formData.append('b_id', b_id);
                formData.append('is_notice', is_notice);
                fileList.forEach(function(file) {
                    formData.append('fileAttachment', file);
                });

                $.ajax({
                    type: 'POST',
                    url: '/Company/UploadFileController',
                    data: formData,
                    contentType: false,
                    processData: false,
                    success: function(response) {
                        console.log("Files uploaded successfully");
                        window.location.href = '/Company/BoardList.board';
                    },
                    error: function(xhr, status, error) {
                        console.log("Error uploading files: " + error);
                        alert('파일 업로드에 실패했습니다: ' + error);
                    }
                });
            },
            error: function(xhr, status, error) {
                console.log(xhr.responseText);
                alert('게시글 수정에 실패했습니다: ' + error);
            }
        });
    });

    window.onbeforeunload = function(e) {
        if (isFormModified) {
            var confirmationMessage = '작성중인 내용이 있습니다. 정말 다른 메뉴로 이동하겠습니까?';
            (e || window.event).returnValue = confirmationMessage;
            return confirmationMessage;
        }
    };
});
