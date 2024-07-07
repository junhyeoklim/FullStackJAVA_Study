$(document).ready(function() {
    var isFormModified = false;

    $('#summernote').summernote({
        height: 300,
        callbacks: {
            onImageUpload: function(files) {
                for (var i = 0; i < files.length; i++) {
                    sendFile(files[i]);
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

    // Add this line to set the content to summernote
    var content = $('#content').text();
    $('#summernote').summernote('code', content);

    $("#title").on('input', function() {
        isFormModified = true;
    });

    function sendFile(file) {
        var data = new FormData();
        data.append('file', file);
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

    $('#submit').on('click', function() {
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
            return false; // 폼 제출 방지
        }

        isFormModified = false; // 폼이 제출된 후에는 경고 창을 표시하지 않음

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
                window.location.href = '/Company/BoardList.board';
            },
            error: function(xhr, status, error) {
                console.log(xhr.responseText);
                alert('게시글 수정에 실패했습니다: ' + error);
            }
        });
    });

    // Warn user if they attempt to leave the page with unsaved changes
    window.onbeforeunload = function(e) {
        if (isFormModified) {
            var confirmationMessage = '작성중인 내용이 있습니다. 정말 다른 메뉴로 이동하겠습니까?';
            (e || window.event).returnValue = confirmationMessage; // Gecko and Trident
            return confirmationMessage; // Gecko and WebKit
        }
    };
});
