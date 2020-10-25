package com.zlab.dzuko.dao;

import com.zlab.dzuko.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {
}
