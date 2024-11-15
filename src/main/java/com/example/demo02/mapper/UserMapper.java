package com.example.demo02.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo02.domain.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper extends BaseMapper<Users>
{

    @Select("SELECT * FROM users WHERE u_phone = #{uPhone} AND u_account_password = #{uAccountPassword}")
    Users findByPhoneAndPassword(Users users);


    // 自定义查询方法：根据uid查询用户
    @Select("SELECT * FROM users WHERE uid = #{uid}")
    Users findByUid(String uid);

    // 自定义查询方法：根据手机号查询用户
    @Select("SELECT * FROM users WHERE u_phone = #{uPhone}")
    Users findByPhone(String uPhone);

    // 获取用户的当前余额
    @Select("SELECT u_balance FROM users WHERE uid = #{uid}")
    double getCurrentBalance(@Param("uid") String uid);

    // 更新用户余额
    @Update("UPDATE users SET u_balance = u_balance + #{uBalance} WHERE uid = #{uid}")
    int updateBalance(Users user);

    // 更新用户负债
    @Update("UPDATE users SET u_liability = u_liability + #{uLiability} WHERE uid = #{uid}")
    int updateLiability(Users user);

    // 更新用户密码
    @Update("UPDATE users SET u_account_password = #{newPassword} WHERE u_phone = #{uPhone}")
    int updatePassword(@Param("uPhone") String uPhone, @Param("newPassword") String newPassword);
}
