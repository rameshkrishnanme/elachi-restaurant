package com.blacksystemse.spring.boot.microservices.elachi.domain;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the restaurants database table.
 * 
 */
@Entity
@Table(name="restaurants")
@NamedQuery(name="Restaurant.findAll", query="SELECT r FROM Restaurant r")
public class Restaurant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idRESTAURANTS;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="RESTAURANT_CREATED_DATE")
	private Date restaurantCreatedDate;

	@Column(name="RESTAURANT_DESC")
	private String restaurantDesc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="RESTAURANT_LASTMODIFIED_DATE")
	private Date restaurantLastmodifiedDate;

	@Column(name="RESTAURANT_NAME")
	private String restaurantName;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="CITY_ID")
	private City city;

	//bi-directional many-to-one association to RestaurantsMenu
	@OneToMany(mappedBy="restaurant")
	private List<RestaurantsMenu> restaurantsMenus;

	//bi-directional many-to-one association to RestaurantsTable
	@OneToMany(mappedBy="restaurant")
	private List<RestaurantsTable> restaurantsTables;

	public Restaurant() {
	}

	public int getIdRESTAURANTS() {
		return this.idRESTAURANTS;
	}

	public void setIdRESTAURANTS(int idRESTAURANTS) {
		this.idRESTAURANTS = idRESTAURANTS;
	}

	public Date getRestaurantCreatedDate() {
		return this.restaurantCreatedDate;
	}

	public void setRestaurantCreatedDate(Date restaurantCreatedDate) {
		this.restaurantCreatedDate = restaurantCreatedDate;
	}

	public String getRestaurantDesc() {
		return this.restaurantDesc;
	}

	public void setRestaurantDesc(String restaurantDesc) {
		this.restaurantDesc = restaurantDesc;
	}

	public Date getRestaurantLastmodifiedDate() {
		return this.restaurantLastmodifiedDate;
	}

	public void setRestaurantLastmodifiedDate(Date restaurantLastmodifiedDate) {
		this.restaurantLastmodifiedDate = restaurantLastmodifiedDate;
	}

	public String getRestaurantName() {
		return this.restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<RestaurantsMenu> getRestaurantsMenus() {
		return this.restaurantsMenus;
	}

	public void setRestaurantsMenus(List<RestaurantsMenu> restaurantsMenus) {
		this.restaurantsMenus = restaurantsMenus;
	}

	public RestaurantsMenu addRestaurantsMenus(RestaurantsMenu restaurantsMenus) {
		getRestaurantsMenus().add(restaurantsMenus);
		restaurantsMenus.setRestaurant(this);

		return restaurantsMenus;
	}

	public RestaurantsMenu removeRestaurantsMenus(RestaurantsMenu restaurantsMenus) {
		getRestaurantsMenus().remove(restaurantsMenus);
		restaurantsMenus.setRestaurant(null);

		return restaurantsMenus;
	}

	public List<RestaurantsTable> getRestaurantsTables() {
		return this.restaurantsTables;
	}

	public void setRestaurantsTables(List<RestaurantsTable> restaurantsTables) {
		this.restaurantsTables = restaurantsTables;
	}

	public RestaurantsTable addRestaurantsTable(RestaurantsTable restaurantsTable) {
		getRestaurantsTables().add(restaurantsTable);
		restaurantsTable.setRestaurant(this);

		return restaurantsTable;
	}

	public RestaurantsTable removeRestaurantsTable(RestaurantsTable restaurantsTable) {
		getRestaurantsTables().remove(restaurantsTable);
		restaurantsTable.setRestaurant(null);

		return restaurantsTable;
	}

}