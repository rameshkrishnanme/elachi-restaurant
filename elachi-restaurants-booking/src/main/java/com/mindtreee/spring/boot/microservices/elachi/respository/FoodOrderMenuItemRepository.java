package com.mindtreee.spring.boot.microservices.elachi.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtreee.spring.boot.microservices.elachi.domain.FoodOrderMenuItem;

public interface FoodOrderMenuItemRepository extends JpaRepository<FoodOrderMenuItem, Long> {

}
