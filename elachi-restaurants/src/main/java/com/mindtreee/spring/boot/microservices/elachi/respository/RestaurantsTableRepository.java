package com.mindtreee.spring.boot.microservices.elachi.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtreee.spring.boot.microservices.elachi.domain.RestaurantsTable;

public interface RestaurantsTableRepository extends JpaRepository<RestaurantsTable, Long> {

}
