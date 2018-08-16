package shaomai.dao;

import org.apache.ibatis.annotations.*;
import shaomai.model.p.User;

@Mapper
public interface UserDao {

    @Insert(
            "insert into tb_user(u_number,u_email,u_level,u_name,u_password,u_company,u_title,u_avatar,u_introduction)" +
                    " values(#{number},#{email},#{level},#{name},#{password},#{company},#{title},#{avatar},#{introduction})"
    )
    int insert(User user);


    @Select(
            "select * from tb_user where u_name=#{username} and u_password=#{password}"
    )
    @Results({
            @Result(property = "id", column = "u_id"),
            @Result(property = "number", column = "u_number"),
            @Result(property = "email", column = "u_email"),
            @Result(property = "level", column = "u_level"),
            @Result(property = "name", column = "u_name"),
            @Result(property = "password", column = "u_password"),
            @Result(property = "company", column = "u_company"),
            @Result(property = "title", column = "u_title"),
            @Result(property = "avatar", column = "u_avatar"),
            @Result(property = "introduction", column = "u_introduction")
    })
    User login(@Param("username") String username, @Param("password")String password);
}
