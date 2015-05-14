package cz.cvut.fel.aos.forum.service;

import cz.cvut.fel.aos.forum.dto.*;
import cz.cvut.fel.aos.forum.entity.*;
import cz.cvut.fel.aos.forum.helpers.PersistenceTools;
import java.util.List;

public class CategoryServiceImpl extends AbstractDataAccessService implements CategoryService {

    @Override
    public List<CategoryDTO> getAll() {
        return PersistenceTools.getCategoryDtos(genericDao.getAll(Category.class));
    }

    @Override
    public List<CategoryDTO> find(String sort, String filter, int base, int offset) {
        if (sort == "") {
            sort = "e.id asc";
        } else {
            sort = "e." + sort.replace(":", " ");
        }
        return PersistenceTools.getCategoryDtos(genericDao.getPage(sort, filter, base, offset, Category.class));
    }

    @Override
    public CategoryDTO get(Long id) {
        return PersistenceTools.getCategoryDto(genericDao.getById(id, Category.class));
    }

    @Override
    public void delete(Long id) {
        genericDao.removeById(id, Category.class);
    }


    @Override
    public Long save(CategoryDTO dto) {
        Category entity = PersistenceTools.getCategoryEntity(dto);

        return genericDao.saveOrUpdate(entity).getId();
    }


    public Long getCount() {
        return genericDao.getCount(Category.class);
    }

}
