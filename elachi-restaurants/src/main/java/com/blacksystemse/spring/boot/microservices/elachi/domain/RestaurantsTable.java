package com.blacksystemse.spring.boot.microservices.elachi.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the restaurants_table database table.
 * 
 */
@Entity
@Table(name="restaurants_table")
@NamedQuery(name="RestaurantsTable.findAll", query="SELECT r FROM RestaurantsTable r")
public class RestaurantsTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idRESTAURANTS_TABLE;

	@Column(name="RESTAURANTS_TABLE_CREATED_DATE")
	private String restaurantsTableCreatedDate;

	@Column(name="RESTAURANTS_TABLE_LASTMODIFIED_DATE")
	private String restaurantsTableLastmodifiedDate;

	@Column(name="RESTAURANTS_TABLE_NAME")
	private String restaurantsTableName;

	@Column(name="RESTAURANTS_TABLE_PRICE")
	private String restaurantsTablePrice;

	//bi-directional many-to-one association to Restaurant
	@ManyToOne
	@JoinColumn(name="RESTAURANTS_ID")
	private Restaurant restaurant;

	public RestaurantsTable() {
	}

	public int getIdRESTAURANTS_TABLE() {
		return this.idRESTAURANTS_TABLE;
	}

	public void setIdRESTAURANTS_TABLE(int idRESTAURANTS_TABLE) {
		this.idRESTAURANTS_TABLE = idRESTAURANTS_TABLE;
	}

	public String getRestaurantsTableCreatedDate() {
		return this.restaurantsTableCreatedDate;
	}

	public void setRestaurantsTableCreatedDate(String restaurantsTableCreatedDate) {
		this.restaurantsTableCreatedDate = restaurantsTableCreatedDate;
	}

	public String getRestaurantsTableLastmodifiedDate() {
		return this.restaurantsTableLastmodifiedDate;
	}

	public void setRestaurantsTableLastmodifiedDate(String restaurantsTableLastmodifiedDate) {
		this.restaurantsTableLastmodifiedDate = restaurantsTableLastmodifiedDate;
	}

	public String getRestaurantsTableName() {
		return this.restaurantsTableName;
	}

	public void setRestaurantsTableName(String restaurantsTableName) {
		this.restaurantsTableName = restaurantsTableName;
	}

	public String getRestaurantsTablePrice() {
		return this.restaurantsTablePrice;
	}

	public void setRestaurantsTablePrice(String restaurantsTablePrice) {
		this.restaurantsTablePrice = restaurantsTablePrice;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}