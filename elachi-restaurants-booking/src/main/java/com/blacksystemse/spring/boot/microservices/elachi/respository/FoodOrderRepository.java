package com.blacksystemse.spring.boot.microservices.elachi.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blacksystemse.spring.boot.microservices.elachi.domain.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {

}
