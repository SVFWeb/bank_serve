package com.example.demo02.mapper;

import com.example.demo02.domain.contract;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Mapper
public interface ContractMapper extends BaseMapper<contract> {


    //查询表中所有数据
    @Select("SELECT * FROM contract")
    List<contract> findContract();
    // 自定义查询方法：
    @Select("SELECT * FROM contract WHERE cid = #{cid}")
    contract findByCid(String cid);

    //查询uid的借款合同合同
    @Select("SELECT * FROM contract WHERE uid = #{uid}")
    List<contract> findByContract(String uid);

    //根据cid删除用户的某一个借款合同
    @Delete("delete from contract where cid = #{cid}")
    Integer delByCid(String cid);

    //根据cid对某个借款金额进行修改
    // @Update("UPDATE contract SET uid = #{uid}, c_name = #{cName}, c_loan_amount = #{cLoanAmount}, c_time = #{cTime} WHERE cid = #{cid}")
    //    void updateContractByCid(Contract contract);
    @Update("UPDATE contract SET  c_loan_amount = c_loan_amount + #{cLoanAmount} WHERE cid = #{cid} ")

        int updateLoanAmount(@Param("cid") String cid, @Param("cLoanAmount") Integer cLoanAmount);


    //添加一条合同
//    @Insert("INSERT INTO contract (uid, cid, c_name, c_loan_amount, c_time) VALUES (#{uid}, #{cid}, #{cName}, #{cLoanAmount}, #{cTime})")
//    int insertContract(
//            @Param("uid") String uid,
//            @Param("cid") String cid,
//            @Param("cName") String cName,
//            @Param("cLoanAmount") Integer cLoanAmount,
//            @Param("cTime") LocalDateTime cTime
//    );


    @Insert("INSERT INTO contract (uid, cid, c_name, c_loan_amount, c_time) VALUES (#{uid}, #{cid}, #{cName}, #{cLoanAmount}, #{cTime,jdbcType=TIMESTAMP})")
    int insertContract(contract contract);




}



