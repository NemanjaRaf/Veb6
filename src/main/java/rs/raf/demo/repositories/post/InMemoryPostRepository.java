package rs.raf.demo.repositories.post;


import rs.raf.demo.entities.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryPostRepository implements PostRepository {
    private static List<Post> posts = new CopyOnWriteArrayList<>();

    public InMemoryPostRepository() {
        System.out.println(this);
    }

    @Override
    public synchronized Post addPost(Post subject) {
        Integer id = posts.size();
        subject.setId(id);
        posts.add(Math.toIntExact(id), subject);

        return subject;
    }

    @Override
    public List<Post> allPosts() {
        return new ArrayList<>(posts);
    }

    @Override
    public Post findPost(Integer id) {
        return posts.get(id);
    }

    @Override
    public void deletePost(Integer id) {
        posts.remove(id.intValue());
    }
}
