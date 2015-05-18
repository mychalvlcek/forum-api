package cz.cvut.fel.wa2.forum.service;

import cz.cvut.fel.wa2.forum.dto.PostDTO;

import java.util.List;

public interface PostService {

    public List<PostDTO> getAll();

    public List<PostDTO> find(Long catId);

    public PostDTO get(Long id);

    public void delete(Long id);

    public Long getCount();

    public Long save(PostDTO dto);
}
