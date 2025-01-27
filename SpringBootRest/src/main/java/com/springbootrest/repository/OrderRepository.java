package com.springbootrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrest.entity.Order1;

public interface OrderRepository extends JpaRepository<Order1, Integer> {

}
