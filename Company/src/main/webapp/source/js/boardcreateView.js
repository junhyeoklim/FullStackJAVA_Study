$(document).ready(function(){
    $("#submit").click(function(){
        if($("#title").val().trim() === "" || $('#summernote').summernote('isEmpty')){
            alert("제목과 내용을 입력해주세요.");
            return false;
        }
        return true;
    });

  $('#summernote').summernote({
                height: 300,
                callbacks: {
                    onImageUpload: function(files) {
                        for (var i = 0; i < files.length; i++) {
                            sendFile(files[i]);
                        }
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
                        // 이미지 삽입 전 <br> 태그 추가
                        var range = $('#summernote').summernote('createRange');
                        range.pasteHTML('<br>'); // <br> 태그 삽입
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

                if (title === "" || content === "") {
                    alert("제목과 내용을 입력해 주세요.");
                    return;
                }

                $.ajax({
                    type: 'POST',
                    url: '/Company/SubmitPost.board',
                    data: {
                        title: title,
                        content: content
                    },
                    success: function(response) {
                        window.location.href = 'User_View/boardList.jsp';
                    },
                    error: function(xhr, status, error) {
                        console.log(xhr.responseText);
                        alert('게시글 작성에 실패했습니다: ' + error);
                    }
                });
            });
          });