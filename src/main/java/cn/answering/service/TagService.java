package cn.answering.service;

import cn.answering.domain.Tag;


public interface TagService{

	//Updating the existing tag by passing the changed one 
    public Tag updateTag(Tag tag);
    
    //Delete Tag by Id
    public void deleteTag(String id);

    //Find Tag by Id 
    public Tag findTagById(String id);
}
