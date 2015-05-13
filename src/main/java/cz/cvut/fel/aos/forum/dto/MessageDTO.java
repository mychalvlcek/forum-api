package cz.cvut.fel.aos.forum.dto;

import java.util.Date;

/**
 *
 * @author vlcekmi3
 */
public class MessageDTO extends AbstractDTO {
    private String title;
    private String content;
    private UserDTO author;
    private UserDTO recipient;

    public MessageDTO() {
    }

    public MessageDTO(Long id, String title, String content, UserDTO author, UserDTO recipient, Date created, Date updated) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.recipient = recipient;
        this.created = created;
        this.updated = updated;
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

    public UserDTO getAuthor() {
        return author;
    }

    public void setAuthor(UserDTO author) {
        this.author = author;
    }

    public UserDTO getRecipient() {
        return recipient;
    }

    public void setRecipient(UserDTO recipient) {
        this.recipient = recipient;
    }

}