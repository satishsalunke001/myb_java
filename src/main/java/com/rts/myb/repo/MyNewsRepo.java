package com.rts.myb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyNews;

@Repository
public interface MyNewsRepo extends JpaRepository<MyNews, Integer>{

}
