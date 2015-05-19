package cz.cvut.fel.wa2.forum.service;

import cz.cvut.fel.wa2.forum.dto.UserDTO;
import cz.cvut.fel.wa2.forum.entity.Role;
import cz.cvut.fel.wa2.forum.entity.User;
import cz.cvut.fel.wa2.forum.helpers.PersistenceTools;

import java.util.List;

public class UserServiceImpl extends AbstractDataAccessService implements UserService {

    @Override
    public List<UserDTO> getAll() {
        return PersistenceTools.getUserDtos(genericDao.getAll(User.class));
    }

    @Override
    public List<UserDTO> find(String sort, String filter, int base, int offset) {
        if (sort == "") {
            sort = "e.id asc";
        } else {
            sort = "e." + sort.replace(":", " ");
        }
        return PersistenceTools.getUserDtos(genericDao.getPage(sort, filter, base, offset, User.class));
    }

    @Override
    public UserDTO get(Long id) {
        return PersistenceTools.getUserDto(genericDao.getById(id, User.class));
    }

    @Override
    public void delete(Long id) {
        genericDao.removeById(id, User.class);
    }


    @Override
    public Long save(UserDTO userDTO) {
        User user = PersistenceTools.getUserEntity(userDTO);
        user.addRole(genericDao.getByPropertyUnique("name", "ROLE_USER", Role.class));

        return genericDao.saveOrUpdate(user).getId();
    }


    public Long getCount() {
        return genericDao.getCount(User.class);
    }
}
