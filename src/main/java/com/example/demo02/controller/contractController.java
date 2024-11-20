package com.example.demo02.controller;


import com.example.demo02.domain.contract;


import com.example.demo02.mapper.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/cont")
@CrossOrigin
@Validated
public class contractController {


    @Autowired
    private ContractMapper contractMapper;


    @PostMapping("/find")
    public contract getContInfo1(@RequestBody contract cont) {
        return (contract) contractMapper.findByCid(cont.getCid());
    }

    //findContract
    @GetMapping("/findContract")
    public List<contract> getConracts() {
        return contractMapper.findContract();
    }


    //根据uid查询用户的借款合同
    @PostMapping("/finduid")
    public List<contract> getContList(@RequestBody contract cont) {
        return contractMapper.findByContract(cont.getUid());
    }

    //delByCid 根据cid删除某一条借款合同
    @PostMapping("/delonecid")
    public Integer getContInfo12(@RequestBody contract cont) {
        return contractMapper.delByCid(cont.getCid()); //执行成功返回了个1
    }


    //根据cid对某一条借款合同的金额进行修改
    //http://localhost:8080/cont/updateAmount?cid=1&cLoanAmount=4000
    @PostMapping("/updateAmount")
    public ResponseEntity<Integer> updateLoanAmount(@RequestParam String cid, @RequestParam int cLoanAmount) {

        int rowsAffected = contractMapper.updateLoanAmount(cid, cLoanAmount);
        return ResponseEntity.ok(rowsAffected);
    }



//    @PostMapping("/addcontract")
//    public int addContract(
//            @RequestParam String uid,
//            @RequestParam String cid,
//            @RequestParam String cName,
//            @RequestParam(required = false, defaultValue = "0") Integer cLoanAmount,
//            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime cTime) {
//
//
//        return contractMapper.insertContract(uid, cid, cName, cLoanAmount, cTime);
//    }

    //添加一条合同
    @PostMapping("/addcontract")
    public int addContract(@RequestBody contract contract) {
        // 注意：如果cTime为null，你可能需要在这里设置默认值（例如当前时间）
        if (contract.getcTime() == null) {
            contract.setcTime(String.valueOf(LocalDateTime.now()));
        }

        return   contractMapper.insertContract(contract);
    }






//    @GetMapping
//    public List<Contract> getAllContracts() {
//        return contractService.list();
//    }

    @GetMapping("/findstr")
    public String getCont() {
        return "11";
    }


}
