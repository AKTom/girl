package com.controlcenter.controller;

import com.controlcenter.domain.Girl;
import com.controlcenter.domain.Result;
import com.controlcenter.repostitory.GirlRepostitory;
import com.controlcenter.service.GirlService;
import com.controlcenter.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class GirlController {
    @Autowired
    private GirlRepostitory girlRepostitory;

    @Autowired
    private GirlService girlService;
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepostitory.findAll();
    }
    //新增一个女生
    @PostMapping(value = "/girls")
    public Result girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return null;
          //return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepostitory.save(girl));
    }
    //查询一个女生
    @GetMapping(value = "/girl/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepostitory.findOne(id);
    }
    //更新一个女生
    @PutMapping(value = "/girl/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setId(id);
        return girlRepostitory.save(girl);
    }
    //删除一个女生
    @DeleteMapping(value = "/girl/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepostitory.delete(id);
    }
    //通过年龄查询女生列表
    @GetMapping(value = "/girl/age/{age}")
    public List<Girl> findGirlByAge(@PathVariable("age") Integer age){
        return girlRepostitory.findByAge(age);
    }

    //同时插入两个女生
    @PostMapping(value = "/girl/two")
    public void insertTwo(){
        girlService.insertTwo();
    }
    @PostMapping(value = "/girl/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
}
