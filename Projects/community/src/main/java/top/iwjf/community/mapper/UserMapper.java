package top.iwjf.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.iwjf.community.model.User;

@Mapper
public interface UserMapper {

    /**
     * 向user表中插入从github中获取的数据
     * @param user
     */
    @Insert("insert into user(name, account_id, token, gmt_create, gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreated},#{gmtModified})")
    void insert(User user);

    /**
     * 从user表中查询token获取登陆状态，实现持久化登录
     * @param token
     * @return
     */
    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
}
