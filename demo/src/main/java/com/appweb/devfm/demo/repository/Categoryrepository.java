package com.appweb.devfm.demo.repository;

import com.appweb.devfm.demo.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Categoryrepository extends JpaRepository<Category, Integer> {

    Category findByCategoryName(String categoryName);

}