package com.blacksystemse.spring.boot.microservices.elachi.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blacksystemse.spring.boot.microservices.elachi.domain.Restaurant;

public interface RestaurantsRepository extends JpaRepository<Restaurant, Long> {

}
