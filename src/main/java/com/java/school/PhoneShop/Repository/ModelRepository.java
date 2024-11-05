package com.java.school.PhoneShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.school.PhoneShop.Entity.Model;

public interface ModelRepository extends JpaRepository<Model, Integer>{

	Model save(Model model);

}
