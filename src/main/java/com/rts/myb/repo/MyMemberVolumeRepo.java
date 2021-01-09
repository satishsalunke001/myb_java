package com.rts.myb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rts.myb.domain.MyMemberVolume;

@Repository
public interface MyMemberVolumeRepo extends JpaRepository<MyMemberVolume, Integer>{

}
