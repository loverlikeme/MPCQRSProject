package cn.answering.service;

import cn.answering.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

	//Update the data of the user that already exists
    public User update(User user);

    //delete the data of the user by id
    public void delete(String id);

    //find the data of a user by Id
    public User findUserById(String id);

    //Find user by page
    public Page<User> findUserByPage(Pageable pageable);

    //Find All Users
    public List<User> findAllUsers();

}
