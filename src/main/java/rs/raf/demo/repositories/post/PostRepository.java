package rs.raf.demo.repositories.post;

import rs.raf.demo.entities.Post;

import java.util.List;

public interface PostRepository {
    public Post addPost(Post subject);
    public List<Post> allPosts();
    public Post findPost(Integer id);
    public void deletePost(Integer id);
}
