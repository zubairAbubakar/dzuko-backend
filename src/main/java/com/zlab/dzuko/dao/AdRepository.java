package com.zlab.dzuko.dao;

import com.zlab.dzuko.entity.Ad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface AdRepository extends JpaRepository<Ad, Long> {

    Page<Ad> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    Page<Ad> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
