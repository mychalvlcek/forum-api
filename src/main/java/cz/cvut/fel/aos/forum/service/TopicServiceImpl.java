package cz.cvut.fel.aos.forum.service;

import cz.cvut.fel.aos.forum.dto.*;
import cz.cvut.fel.aos.forum.entity.*;
import cz.cvut.fel.aos.forum.helpers.PersistenceTools;
import java.util.List;

public class TopicServiceImpl extends AbstractDataAccessService implements TopicService {

    @Override
    public List<TopicDTO> getAll() {
        return PersistenceTools.getTopicDtos(genericDao.getAll(Topic.class));
    }

    @Override
    public List<TopicDTO> find(String sort, String filter, int base, int offset) {
        if (sort == "") {
            sort = "e.id asc";
        } else {
            sort = "e." + sort.replace(":", " ");
        }
        return PersistenceTools.getTopicDtos(genericDao.getPage(sort, filter, base, offset, Topic.class));
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
