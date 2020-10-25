package com.zlab.dzuko.dao;

import com.zlab.dzuko.entity.AdCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "adCategory", path = "ad-category")
public interface AdCategoryRepository extends JpaRepository<AdCategory, Long> {
}
