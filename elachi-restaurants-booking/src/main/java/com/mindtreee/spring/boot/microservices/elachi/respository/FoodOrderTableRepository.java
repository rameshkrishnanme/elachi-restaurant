package com.mindtreee.spring.boot.microservices.elachi.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtreee.spring.boot.microservices.elachi.domain.FoodOrderTable;

public interface FoodOrderTableRepository extends JpaRepository<FoodOrderTable, Long> {

}
	