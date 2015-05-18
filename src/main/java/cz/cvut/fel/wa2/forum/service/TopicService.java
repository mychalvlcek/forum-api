package cz.cvut.fel.wa2.forum.service;

import cz.cvut.fel.wa2.forum.dto.TopicDTO;

import java.util.List;

public interface TopicService {

    public List<TopicDTO> getAll();

    public List<TopicDTO> find(Long catId);

    public TopicDTO get(Long id);

    public void delete(Long id);

    public Long getCount();

    public Long save(TopicDTO dto);
}
