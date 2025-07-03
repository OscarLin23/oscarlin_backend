package com.example.oscarlin.mapper;

import com.example.oscarlin.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectAll(User user);

    User getByUsernameAndPassword(User user);
}
