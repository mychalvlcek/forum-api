package cz.cvut.fel.wa2.forum.service;

import cz.cvut.fel.wa2.forum.dto.*;
import cz.cvut.fel.wa2.forum.entity.*;
import cz.cvut.fel.wa2.forum.helpers.PersistenceTools;
import java.util.List;

public class TopicServiceImpl extends AbstractDataAccessService implements TopicService {

    @Override
    public List<TopicDTO> getAll() {
        return PersistenceTools.getTopicDtos(genericDao.getAll(Topic.class));
    }

    @Override
    public List<TopicDTO> find(Long catId) {
        return PersistenceTools.getTopicDtos(genericDao.getByProperty("category", genericDao.getById(catId, Category.class), Topic.class, "e.updated DESC"));
    }

    @Override
    public TopicDTO get(Long id) {
        return PersistenceTools.getTopicDto(genericDao.getById(id, Topic.class));
    }

    @Override
    public void delete(Long id) {
        genericDao.removeById(id, Category.class);
    }


    @Override
    public Long save(TopicDTO dto) {
        User u = genericDao.getById(dto.getAuthor(), User.class);
        Category c = genericDao.getById(dto.getCategory(), Category.class);
        Topic entity = PersistenceTools.getTopicEntity(dto, u, c);

        return genericDao.saveOrUpdate(entity).getId();
    }


    public Long getCount() {
        return genericDao.getCount(Category.class);
    }

}
