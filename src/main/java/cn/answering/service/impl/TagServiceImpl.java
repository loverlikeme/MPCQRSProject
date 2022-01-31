package cn.answering.service.impl;

import cn.answering.domain.Tag;
import cn.answering.repository.TagRepository;
import cn.answering.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TagServiceImpl implements TagService{

    @Autowired
    private TagRepository tagRepository;


    @Transactional
    @Override
    public Tag updateTag(Tag tag) {
    	//Save or updating existing tag
        return tagRepository.save(tag);
    }

    @Transactional
    @Override
    public void deleteTag(String id) {
    	//delete tag by passing the id to tagRepository
        tagRepository.delete(id);
    }

    @Override
    public Tag findTagById(String id) {
    	//find one tag by Id 
        return tagRepository.findOne(id);
    }
}
