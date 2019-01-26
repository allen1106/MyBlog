package cn.allen.dreamsanreal.service.impl;

import cn.allen.dreamsanreal.dao.mapper.UserMapper;
import cn.allen.dreamsanreal.model.User;
import cn.allen.dreamsanreal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userDao;

    @Override
    public User getUserByName(User user) {
        return userDao.selectByUser(user);
    }
}
