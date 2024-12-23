package com.example.demo02.controller;

import com.example.demo02.domain.Users;
import com.example.demo02.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
@Validated
public class userController {
    @Autowired
    private UserMapper userMapper;

    // 登录
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Users users) {
        Map<String, Object> response = new HashMap<>();

        try {
            Users existingUser = userMapper.findByPhone(users.getuPhone());

            if (existingUser == null) {
                response.put("message", "该手机号未进行注册");
                return ResponseEntity.badRequest().body(response);
            }

            // 验证密码
            if (!existingUser.getuAccountPassword().equals(users.getuAccountPassword())) {
                response.put("message", "密码错误");
                return ResponseEntity.badRequest().body(response);
            }

            response.put("user", existingUser);
            response.put("message", "登录成功");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "系统错误: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }


    // 根据id获取用户信息
    @PostMapping("/userinfo")
    public Users getUserInfo(@RequestBody Users user) {
        return userMapper.findByUid(user.getUid());
    }

    // 注册
    @PostMapping("/register")
    public String register(@RequestBody Users user) {
        Users existingUser = userMapper.findByPhone(user.getuPhone());
        if (existingUser != null) {
            return "手机号已存在，不允许重复注册";
        }
        userMapper.insert(user);
        return "注册成功";
    }


    // 修改用户余额

    /**
     * @param user uid用户编号
     * @param user uBalance金额
     */
    @PutMapping("/update/balance")
    public ResponseEntity<String> updateBalance(@RequestBody Users user) {
        Users newUser = userMapper.selectById(user.getUid());
        newUser.setuBalance(newUser.getuBalance() + user.getuBalance());
        if (newUser.getuBalance() < 0) return ResponseEntity.ok("余额不足");
        int result = userMapper.updateById(newUser);
        if (result > 0) {
            return ResponseEntity.ok("余额更新成功");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("更新失败");
        }
    }

    // 修改用户负债
    @PutMapping("/update/liability")
    public ResponseEntity<String> updateLiability(@RequestBody Users user) {

        Users newUser = userMapper.selectById(user.getUid());

        newUser.setuLiability(newUser.getuLiability() + user.getuLiability());

        int result = userMapper.updateById(newUser);

        if (result > 0) {
            return ResponseEntity.ok("负债更新成功");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("用户不存在或更新失败");
        }
    }

    // 修改用户密码接口
    @PostMapping("/update/password")
    public ResponseEntity<String> updatePassword(@RequestBody Users user) {
        // 查找用户
        Users existingUser = userMapper.findByPhone(user.getuPhone());
        if (existingUser == null) {
            return ResponseEntity.ok("该手机号未进行注册");
        }

        // 更新密码
        int result = userMapper.updatePassword(user.getuPhone(), user.getuAccountPassword());
        if (result > 0) {
            return ResponseEntity.ok("密码更新成功");
        } else {
            return ResponseEntity.ok("密码更新失败");
        }
    }

    // 根据 id 获取除该 id 外的其他用户的 uid、user_name 和 u_balance
    @GetMapping("/except/{id}")
    public ResponseEntity<Object> getUsersExceptId(@PathVariable String id) {
        List<Map<String, Object>> users = userMapper.getUsersExceptId(id);
        if (users == null || users.isEmpty()) {
            return ResponseEntity.ok("暂无数据");
        } else {
            return ResponseEntity.ok(users);
        }
    }

    // 更新用户信息（）
    @PutMapping("/update")
    public Integer updateUser(@RequestBody Users user) {
        return userMapper.updateById(user);
    }
}
