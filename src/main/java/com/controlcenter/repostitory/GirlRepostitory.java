package com.controlcenter.repostitory;

import com.controlcenter.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface GirlRepostitory extends JpaRepository<Girl,Integer>{

   public List<Girl> findByAge(Integer age);
}
