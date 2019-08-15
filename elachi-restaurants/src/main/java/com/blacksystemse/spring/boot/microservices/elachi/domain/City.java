package com.blacksystemse.spring.boot.microservices.elachi.domain;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCITY;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CITY_CREATED_DATE")
	private Date cityCreatedDate;

	@Column(name="CITY_DESC")
	private String cityDesc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CITY_LASTMODIFIED_DATE")
	private Date cityLastmodifiedDate;

	@Column(name="CITY_NAME")
	private String cityName;

	//bi-directional many-to-one association to Restaurant
	@OneToMany(mappedBy="city")
	private List<Restaurant> restaurants;

	public City() {
	}

	public int getIdCITY() {
		return this.idCITY;
	}

	public void setIdCITY(int idCITY) {
		this.idCITY = idCITY;
	}

	public Date getCityCreatedDate() {
		return this.cityCreatedDate;
	}

	public void setCityCreatedDate(Date cityCreatedDate) {
		this.cityCreatedDate = cityCreatedDate;
	}

	public String getCityDesc() {
		return this.cityDesc;
	}

	public void setCityDesc(String cityDesc) {
		this.cityDesc = cityDesc;
	}

	public Date getCityLastmodifiedDate() {
		return this.cityLastmodifiedDate;
	}

	public void setCityLastmodifiedDate(Date cityLastmodifiedDate) {
		this.cityLastmodifiedDate = cityLastmodifiedDate;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<Restaurant> getRestaurants() {
		return this.restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public Restaurant addRestaurant(Restaurant restaurant) {
		getRestaurants().add(restaurant);
		restaurant.setCity(this);

		return restaurant;
	}

	public Restaurant removeRestaurant(Restaurant restaurant) {
		getRestaurants().remove(restaurant);
		restaurant.setCity(null);

		return restaurant;
	}

}