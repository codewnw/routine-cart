package com.routinecart.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.routinecart.model.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>{
	

}
