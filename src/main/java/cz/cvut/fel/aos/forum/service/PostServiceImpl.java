package cz.cvut.fel.aos.forum.service;

import cz.cvut.fel.aos.forum.dto.*;
import cz.cvut.fel.aos.forum.entity.*;
import cz.cvut.fel.aos.forum.helpers.PersistenceTools;
import java.util.List;

public class PostServiceImpl extends AbstractDataAccessService implements PostService {

    @Override
    public List<PostDTO> getAll() {
        return PersistenceTools.getPostDtos(genericDao.getAll(Post.class));
    }

    @Override
    public List<PostDTO> find(Long topicId) {
        return PersistenceTools.getPostDtos(genericDao.getByProperty("topic", genericDao.getById(topicId, Topic.class), Post.class));
    }

    @Override
    public PostDTO get(Long id) {
        return PersistenceTools.getPostDto(genericDao.getById(id, Post.class));
    }

    @Override
    public void delete(Long id) {
        genericDao.removeById(id, Post.class);
    }


    @Override
    public Long save(PostDTO dto) {
        User u = genericDao.getById(dto.getAuthor(), User.class);
        Topic t = genericDao.getById(dto.getTopicId(), Topic.class);
        Post entity = PersistenceTools.getPostEntity(dto, u, t);

        return genericDao.saveOrUpdate(entity).getId();
    }


    public Long getCount() {
        return genericDao.getCount(Post.class);
    }

}
