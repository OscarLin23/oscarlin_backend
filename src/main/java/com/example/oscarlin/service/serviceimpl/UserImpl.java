package com.example.oscarlin.service.serviceimpl;

import com.example.oscarlin.domain.User;
import com.example.oscarlin.mapper.UserMapper;
import com.example.oscarlin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
@Slf4j
@Service
public class UserImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> selectAll(User user) {
        return userMapper.selectAll(user);
    }

    @Override
    public User login(User user) {
        User loginUser=userMapper.getByUsernameAndPassword(user);
        return  loginUser;
    }

    @Override
    public User register(User user) {
        try {
            User existUser = userMapper.getByUsernameAndPassword(user);
            if (existUser == null) {
                int result = userMapper.InsertUsernameAndPassword(user);
                if (result > 0) {
                    return user;
                }
            }
            return null;
        } catch (Exception e) {
            log.info("注册过程出错");
            return null;
        }
    }
}
