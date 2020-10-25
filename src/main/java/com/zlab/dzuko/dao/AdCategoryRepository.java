package com.zlab.dzuko.dao;

import com.zlab.dzuko.entity.AdCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "adCategory", path = "ad-category")
public interface AdCategoryRepository extends JpaRepository<AdCategory, Long> {
}
