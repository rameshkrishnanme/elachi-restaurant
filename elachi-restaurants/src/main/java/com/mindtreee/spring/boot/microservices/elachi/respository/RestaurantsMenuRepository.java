package com.mindtreee.spring.boot.microservices.elachi.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtreee.spring.boot.microservices.elachi.domain.RestaurantsMenu;

public interface RestaurantsMenuRepository extends JpaRepository<RestaurantsMenu, Long> {

}
