package cz.cvut.fel.wa2.forum.service;

import cz.cvut.fel.wa2.forum.dto.UserDTO;
import java.util.List;

public interface UserService {

    /**
     * Gets all records
     * @return list of records
     */
    public List<UserDTO> getAll();

    /**
     * Get entities by specific filters
     * @param sort colun name (default by id)
     * @param filter column name to filter
     * @param base limit from
     * @param offset count of records
     * @return list of records
     */
    public List<UserDTO> find(String sort, String filter, int base, int offset);

    /**
     * Retrieves entity by id
     * @param id identifier of entity
     * @return entity
     */
    public UserDTO get(Long id);

    /**
     * Delete entity specified by id
     * @param id of entity
     */
    public void delete(Long id);

    /**
     * Get count of all records
     * @return Long number of records
     */
    public Long getCount();

    /**
     * Save or update entity
     * @param userDTO entity
     */
    public Long save(UserDTO userDTO);
}
