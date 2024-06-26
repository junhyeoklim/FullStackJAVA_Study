package test.board;

import java.util.List;

public class CommentHelper {
    public static String generateCommentsHtml(List<Comment> comments, long parentId, int level) {
        StringBuilder html = new StringBuilder();

        for (Comment comment : comments) {
            if (comment.getParentCommentId() == parentId) {
                html.append("<div class=\"comment\" style=\"margin-left: ").append(level * 20).append("px;\">")
                    .append("<p>작성자: ").append(comment.getUserName()).append("</p>")
                    .append("<p>").append(comment.getContent()).append("</p>")
                    .append("<p>작성일: ").append(comment.getCreateTime()).append("</p>")
                    .append("<p>수정일: ").append(comment.getUpdateTime()).append("</p>")
                    .append("<div class=\"comment-actions\">")
                    .append("<button class=\"edit-btn\" data-comment-id=\"").append(comment.getCommentId()).append("\">수정</button>")
                    .append("<button class=\"delete-btn\" data-comment-id=\"").append(comment.getCommentId()).append("\">삭제</button>")
                    .append("<button class=\"reply-btn\" data-comment-id=\"").append(comment.getCommentId()).append("\">답글</button>")
                    .append("</div>")
                    .append("</div><hr>");
                html.append(generateCommentsHtml(comments, comment.getCommentId(), level + 1));
            }
        }

        return html.toString();
    }
}
