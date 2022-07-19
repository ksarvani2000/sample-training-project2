package com.demo.spring;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring.entity.LineItem;

public interface ItemRepository extends JpaRepository<LineItem, Integer>{

}
