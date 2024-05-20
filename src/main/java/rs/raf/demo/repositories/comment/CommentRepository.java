package rs.raf.demo.repositories.comment;

import rs.raf.demo.entities.Comment;

import java.util.List;

public interface CommentRepository {
    public Comment addComment(Comment comment);
    public List<Comment> getCommentsByPostID(Integer post_id);
}
