package rs.raf.demo.services;

import rs.raf.demo.entities.Comment;
import rs.raf.demo.entities.Post;
import rs.raf.demo.repositories.comment.CommentRepository;
import rs.raf.demo.repositories.post.PostRepository;

import javax.inject.Inject;
import java.util.List;

public class CommentService {
    public CommentService() {
        System.out.println(this);
    }

    @Inject
    private CommentRepository commentRepository;

    public Comment addComment(Comment comment) {
        return this.commentRepository.addComment(comment);
    }

    public List<Comment> getCommentsByPostID(Integer post_id) {
        return this.commentRepository.getCommentsByPostID(post_id);
    }
}
