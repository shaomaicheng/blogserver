package shaomai.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import shaomai.model.p.User;

@Mapper
public interface UserDao {

    @Insert(
            "insert into tb_user(u_number,u_email,u_level,u_name,u_password,u_company,u_title,u_avatar,u_introduction)" +
                    " values(#{number},#{email},#{level},#{name},#{password},#{company},#{title},#{avatar},#{introduction})"
    )
    int insert(User user);
}
