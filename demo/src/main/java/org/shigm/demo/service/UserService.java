package org.shigm.demo.service;

import org.shigm.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public Integer addUser(User user) {
        int update = jdbcTemplate.update("insert into  user (name,age) values (?,?)", user.getName(), user.getAge());
        return update;
        }
    public Integer updateUser(User user){
        return  jdbcTemplate.update("update user  set name=? where id=?",user.getName(),user.getId());
    }
    public List<User> getAll(){
        List<User> list = jdbcTemplate.query("select * from user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String name = resultSet.getString("name");
                User user = new User();
                user.setName(name);
                user.setId(id);
                user.setAge(age);
                return user;
            }
        });
        return list;
    } public List<User> getAll2(){
        List<User> list = jdbcTemplate.query("select * from user",new BeanPropertyRowMapper<>(User.class));
        return list;
    }
}
