package com.demo.spring;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	
}
