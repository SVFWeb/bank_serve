package com.example.demo02.controller;

import com.example.demo02.domain.Flow;
import com.example.demo02.mapper.FlowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flow")
public class flowController {

    @Autowired
    private FlowMapper flowMapper;

    // 添加数据接口
    @PostMapping("/add")
    public ResponseEntity<String> addFlow(@RequestBody Flow flow) {
        int result = flowMapper.insertFlow(flow);
        if (result > 0) {
            return ResponseEntity.ok("数据添加成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("数据添加失败");
        }
    }

    // 获取所有数据接口
    @GetMapping("/all")
    public ResponseEntity<List<Flow>> getAllFlows() {
        List<Flow> flows = flowMapper.getAllFlows();
        if (flows == null || flows.isEmpty()) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.ok(flows);
        }
    }

    // 根据 id 获取所有相关数据接口
    @GetMapping("/{id}")
    public ResponseEntity<Object> getFlowsById(@PathVariable String id) {
        List<Flow> flows = flowMapper.getFlowsById(id);
        if (flows != null && !flows.isEmpty()) {
            return ResponseEntity.ok(flows);
        } else {
            return ResponseEntity.ok("暂无数据");
        }
    }
}