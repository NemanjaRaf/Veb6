package rs.raf.demo.entities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Comment
{
    private Integer post_id;

    @NotNull(message = "content field is required")
    @NotEmpty(message = "content field is required")
    private String content;

    @NotNull(message = "Username field is required")
    @NotEmpty(message = "Username field is required")
    private String username;

    public Comment() {
    }

    public Comment(String content, String username) {
        this();
        this.content = content;
        this.username = username;
    }

    public Comment(String content, String username, Integer post_id) {
        this(content, username);
        this.post_id = post_id;
    }


    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
