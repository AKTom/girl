package com.controlcenter.service;

import com.controlcenter.Exception.GirlException;
import com.controlcenter.enums.ResultEnum;
import com.controlcenter.properties.GilrProperties;
import com.controlcenter.repostitory.GirlRepostitory;
import com.controlcenter.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepostitory girlRepostitory;
    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepostitory.save(girlA);
        Girl girlB = new Girl();
        girlA.setCupSize("B");
        girlA.setAge(19);
        girlRepostitory.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl =girlRepostitory.findOne(id);
        Integer age = girl.getAge();
        if (age<10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10&&age<16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
    public Girl findOne(Integer id){
        return  girlRepostitory.getOne(id);
    }
}
