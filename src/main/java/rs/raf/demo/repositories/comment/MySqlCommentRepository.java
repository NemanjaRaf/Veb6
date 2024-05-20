package rs.raf.demo.repositories.comment;

import rs.raf.demo.entities.Comment;
import rs.raf.demo.entities.Post;
import rs.raf.demo.repositories.MySqlAbstractRepository;
import rs.raf.demo.repositories.post.PostRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlCommentRepository extends MySqlAbstractRepository implements CommentRepository {
    @Override
    public Comment addComment(Comment comment) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.newConnection();

            String[] generatedColumns = {"time"};

            preparedStatement = connection.prepareStatement("INSERT INTO comments (content, user, post_id) VALUES(?, ?, ?)", generatedColumns);
            preparedStatement.setString(1, comment.getContent());
            preparedStatement.setString(2, comment.getUsername());
            preparedStatement.setInt(3, comment.getPost_id());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

//            if (resultSet.next()) {
//                co.setId(resultSet.getInt(1));
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return comment;
    }

    @Override
    public List<Comment> getCommentsByPostID(Integer post_id) {
        List<Comment> comments = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = this.newConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from comments WHERE post_id = " + post_id + " ORDER BY time DESC");
            while (resultSet.next()) {
                comments.add(new Comment(resultSet.getString("content"), resultSet.getString("user"), resultSet.getInt("post_id")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(statement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return comments;
    }
}
