package rs.raf.demo.repositories.comment;

import rs.raf.demo.entities.Comment;
import rs.raf.demo.entities.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryCommentRepository implements CommentRepository {

    private static List<Comment> comments = new CopyOnWriteArrayList<>();

    @Override
    public synchronized Comment addComment(Comment comment) {
        Integer id = comments.size();
        comments.add(Math.toIntExact(id), comment);

        return comment;
    }

    @Override
    public List<Comment> getCommentsByPostID(Integer post_id) {
        List<Comment> commentsByPostID = new ArrayList<>();
        for (Comment comment : comments) {
            if (comment.getPost_id().equals(post_id)) {
                commentsByPostID.add(comment);
            }
        }

        return commentsByPostID;
    }
}
