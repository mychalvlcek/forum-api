package cz.cvut.fel.aos.forum.helpers;

import cz.cvut.fel.aos.forum.dto.*;
import cz.cvut.fel.aos.forum.entity.*;

import java.util.ArrayList;
import java.util.List;

public class PersistenceTools {


    public static UserDTO getUserDto(User u) {
        if(u == null) return null;
        return new UserDTO(u.getId(), u.getUserName(), u.getEmail(), getIdentifiers(u.getMessages()), getIdentifiers(u.getPosts()), getIdentifiers(u.getTopics()), getIdentifiers(u.getRoles()), u.getCreated(), u.getUpdated());
    }

    public static UserDTO getUserSimpleDto(User u) {
        if(u == null) return null;
        return new UserDTO(u.getId(), u.getUserName(), u.getEmail(), null, null, null, getIdentifiers(u.getRoles()), u.getCreated(), u.getUpdated());
    }

    public static User getUserEntity(UserDTO userDTO) {
        User entity = new User();

        if (userDTO != null) {
            entity.setId(userDTO.getId());
            entity.setEmail(userDTO.getEmail());
            entity.setUserName(userDTO.getUsername());
            entity.setPassword(userDTO.getPassword());
        }

        return entity;
    }

    public static CategoryDTO getCategoryDto(Category r) {
        if(r == null) return null;
        return new CategoryDTO(r.getId(), r.getTitle(), getIdentifiers(r.getTopics()), r.getCreated(), r.getUpdated());
    }

    public static Category getCategoryEntity(CategoryDTO dto) {
        Category entity = new Category();

        if (dto != null) {
            entity.setId(dto.getId());
            entity.setTitle(dto.getTitle());
        }

        return entity;
    }

    public static PostDTO getPostDto(Post p) {
        if(p == null) return null;
        return new PostDTO(p.getId(), p.getTitle(), p.getContent(), getUserDto(p.getAuthor()), getTopicDto(p.getTopic()), p.getCreated(), p.getUpdated());
    }

    public static TopicDTO getTopicDto(Topic t) {
        if(t == null) return null;
        return new TopicDTO(t.getId(), t.getTitle(), getIdentifier(t.getAuthor()), getUserSimpleDto(t.getAuthor()), getIdentifier(t.getCategory()), getIdentifiers(t.getPosts()), t.getCreated(), t.getUpdated());
    }

    public static Topic getTopicEntity(TopicDTO dto, User user, Category category) {
        Topic entity = new Topic();

        if (dto != null) {
            entity.setId(dto.getId());
            entity.setTitle(dto.getTitle());
            entity.setAuthor(user);
            entity.setCategory(category);
        }

        return entity;
    }

    public static MessageDTO getMessageDto(Message m) {
        if(m == null) return null;
        Long id = null;
        return new MessageDTO(m.getId(), m.getTitle(), m.getContent(), getUserDto(m.getAuthor()), getUserDto(m.getRecipient()), m.getCreated(), m.getUpdated());
    }


    public static List<Long> getIdentifiers(List<? extends AbstractEntity> list) {
        if (list == null) {
            return null;
        }
        List<Long> ids = new ArrayList<Long>();

        for (AbstractEntity ae : list) {
            ids.add(ae.getId());
        }
        return ids;
    }

    // lists

    public static List<UserDTO> getUserDtos(List<User> records) {
        List<UserDTO> result = new ArrayList<UserDTO>();

        for (User record : records) {
            result.add(getUserDto(record));
        }
        return result;
    }

    public static List<CategoryDTO> getCategoryDtos(List<Category> records) {
        List<CategoryDTO> result = new ArrayList<CategoryDTO>();

        for (Category record : records) {
            result.add(getCategoryDto(record));
        }
        return result;
    }


    public static List<TopicDTO> getTopicDtos(List<? extends Topic> records) {
        if (records == null) {
            return null;
        }
        List<TopicDTO> result = new ArrayList<TopicDTO>();
        for (Topic record : records) {
            result.add(getTopicDto(record));
        }
        return result;
    }

    public static List<PostDTO> getPostDtos(List<? extends Post> records) {
        if (records == null) {
            return null;
        }
        List<PostDTO> result = new ArrayList<PostDTO>();
        for (Post record : records) {
            result.add(getPostDto(record));
        }
        return result;
    }

    public static Long getIdentifier(AbstractEntity o){
        if(o == null) return null;
        Long id = null;
//        if(o instanceof HibernateProxy){
//            id = (Long)((HibernateProxy) o).getHibernateLazyInitializer().getIdentifier();
//        }else{
//            id = o.getId();
//        }
        id = o.getId();
        return id;
    }
}