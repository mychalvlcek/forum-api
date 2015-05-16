package cz.cvut.fel.aos.forum.dto;
import java.util.Date;

/**
 *
 * @author vlcekmi3
 */
public class PostDTO extends AbstractDTO {
    private String title;
    private String content;
    private Long author;
    private Long topicId;
    private UserDTO user;
    private TopicDTO topic;

    public PostDTO() {
    }

    public PostDTO(Long id, String title, String content, Long author, Long topic, Date created, Date updated) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.topicId = topic;
        this.created = created;
        this.updated = updated;
    }

    public PostDTO(Long id, String title, String content, UserDTO user, TopicDTO topic, Date created, Date updated) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.topic = topic;
        this.created = created;
        this.updated = updated;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
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