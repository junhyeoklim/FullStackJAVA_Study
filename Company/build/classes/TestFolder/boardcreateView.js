$(document).ready(function() {
    $('#summernote').summernote({
        placeholder: '내용을 입력하세요.',
        height: 300,
        callbacks: {
            onImageUpload: function(files) {
                uploadImage(files[0]);
            }
        }
    });

    function uploadImage(file) {
        let data = new FormData();
        data.append('file', file);
        $.ajax({
            url: 'upload_image.jsp', // 이미지 업로드 처리 파일
            method: 'POST',
            data: data,
            contentType: false,
            processData: false,
            success: function(response) {
                $('#summernote').summernote('insertImage', response);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error(textStatus + " " + errorThrown);
                alert("이미지 업로드 실패");
            }
        });
    }

    $('#submit').on('click', function() {
        let title = $('#title').val();
        let content = $('#summernote').val();
        $.ajax({
            url: 'save_post.jsp', // 게시글 저장 처리 파일
            method: 'POST',
            data: {
                title: title,
                content: content
            },
            success: function(response) {
                let postID = response.postID;
                if (postID) {
                    window.location.href = 'post_list.jsp';
                } else {
                    alert('게시글 저장에 실패했습니다.');
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error(textStatus + " " + errorThrown);
                alert("게시글 저장 실패");
            }
        });
    });
});
