package com.rts.myb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rts.myb.domain.MyProduct;

public interface MyProductRepo extends JpaRepository<MyProduct, String>{

}
