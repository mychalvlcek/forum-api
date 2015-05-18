package cz.cvut.fel.wa2.forum.dto;

import java.util.List;

/**
 *
 * @author vlcekmi3
 */
public class RoleDTO extends AbstractDTO {
    private String name;
    private List<Long> users;

    public RoleDTO() {
    }

    public RoleDTO(Long id, String name, List<Long> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getUsers() {
        return users;
    }

    public void setUsers(List<Long> users) {
        this.users = users;
    }

}