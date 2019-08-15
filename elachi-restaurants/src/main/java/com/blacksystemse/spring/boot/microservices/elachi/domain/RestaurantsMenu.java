package com.blacksystemse.spring.boot.microservices.elachi.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the restaurants_menu database table.
 * 
 */
@Entity
@Table(name="restaurants_menu")
@NamedQuery(name="RestaurantsMenu.findAll", query="SELECT r FROM RestaurantsMenu r")
public class RestaurantsMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idRESTAURANTS_MENU;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="RESTAURANTS_MENU_CREATED_DATE")
	private Date restaurantsMenuCreatedDate;

	@Column(name="RESTAURANTS_MENU_DESC")
	private String restaurantsMenuDesc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="RESTAURANTS_MENU_LASTMODIFIED_DATE")
	private Date restaurantsMenuLastmodifiedDate;

	@Column(name="RESTAURANTS_MENU_NAME")
	private String restaurantsMenuName;

	@Column(name="RESTAURANTS_MENU_PRICE")
	private float restaurantsMenuPrice;

	//bi-directional many-to-one association to Restaurant
	@ManyToOne
	@JoinColumn(name="RESTAURANTS_ID")
	private Restaurant restaurant;

	public RestaurantsMenu() {
	}

	public int getIdRESTAURANTS_MENU() {
		return this.idRESTAURANTS_MENU;
	}

	public void setIdRESTAURANTS_MENU(int idRESTAURANTS_MENU) {
		this.idRESTAURANTS_MENU = idRESTAURANTS_MENU;
	}

	public Date getRestaurantsMenuCreatedDate() {
		return this.restaurantsMenuCreatedDate;
	}

	public void setRestaurantsMenuCreatedDate(Date restaurantsMenuCreatedDate) {
		this.restaurantsMenuCreatedDate = restaurantsMenuCreatedDate;
	}

	public String getRestaurantsMenuDesc() {
		return this.restaurantsMenuDesc;
	}

	public void setRestaurantsMenuDesc(String restaurantsMenuDesc) {
		this.restaurantsMenuDesc = restaurantsMenuDesc;
	}

	public Date getRestaurantsMenuLastmodifiedDate() {
		return this.restaurantsMenuLastmodifiedDate;
	}

	public void setRestaurantsMenuLastmodifiedDate(Date restaurantsMenuLastmodifiedDate) {
		this.restaurantsMenuLastmodifiedDate = restaurantsMenuLastmodifiedDate;
	}

	public String getRestaurantsMenuName() {
		return this.restaurantsMenuName;
	}

	public void setRestaurantsMenuName(String restaurantsMenuName) {
		this.restaurantsMenuName = restaurantsMenuName;
	}

	public float getRestaurantsMenuPrice() {
		return this.restaurantsMenuPrice;
	}

	public void setRestaurantsMenuPrice(float restaurantsMenuPrice) {
		this.restaurantsMenuPrice = restaurantsMenuPrice;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}