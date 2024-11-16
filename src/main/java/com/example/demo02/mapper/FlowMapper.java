package com.example.demo02.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo02.domain.Flow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import java.util.List;

@Mapper
public interface FlowMapper extends BaseMapper<Flow> {

    // 插入数据
    @Insert("INSERT INTO flow (time, id, user_name, financial_type, income_money, compute_money, remark) " +
            "VALUES (#{time}, #{id}, #{userName}, #{financialType}, #{incomeMoney}, #{computeMoney}, #{remark})")
    int insertFlow(Flow flow);

    // 查询所有数据
    @Select("SELECT time, id, user_name, financial_type, income_money, compute_money, remark FROM flow")
    @Results({
            @Result(property = "time", column = "time"),
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "financialType", column = "financial_type"),
            @Result(property = "incomeMoney", column = "income_money"),
            @Result(property = "computeMoney", column = "compute_money"),
            @Result(property = "remark", column = "remark")
    })
    List<Flow> getAllFlows();

    // 根据 id 获取所有相关数据
    @Select("SELECT time, id, user_name, financial_type, income_money, compute_money, remark FROM flow WHERE id = #{id}")
    @Results({
            @Result(property = "time", column = "time"),
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "financialType", column = "financial_type"),
            @Result(property = "incomeMoney", column = "income_money"),
            @Result(property = "computeMoney", column = "compute_money"),
            @Result(property = "remark", column = "remark")
    })
    List<Flow> getFlowsById(String id);
}