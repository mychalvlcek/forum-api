package cz.cvut.fel.aos.forum.dto;
import java.util.Date;

/**
 *
 * @author vlcekmi3
 */
public class PostDTO extends AbstractDTO {
    private String title;
    private String content;
    private UserDTO author;
    private TopicDTO topic;

    public PostDTO() {
    }

    public PostDTO(Long id, String title, String content, UserDTO author, TopicDTO topic, Date created, Date updated) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.topic = topic;
        this.created = created;
        this.updated = updated;
    }

    public UserDTO getAuthor() {
        return author;
    }

    public void setAuthor(UserDTO author) {
        this.author = author;
    }

    public TopicDTO getTopic() {
        return topic;
    }

    public void setTopic(TopicDTO topic) {
        this.topic = topic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}