package com.mindtreee.spring.boot.microservices.elachi.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the food_order database table.
 * 
 */
@Entity
@Table(name="food_order")
@NamedQuery(name="FoodOrder.findAll", query="SELECT f FROM FoodOrder f")
public class FoodOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idFOOD_ORDER;

	@Column(name="FOOD_ORDER_CREATED_DATE")
	private String foodOrderCreatedDate;

	@Column(name="FOOD_ORDER_FINAL_TOT_PRICE")
	private float foodOrderFinalTotPrice;

	@Column(name="FOOD_ORDER_LASTMODIFIED_DATE")
	private String foodOrderLastmodifiedDate;

	@Column(name="FOOD_ORDER_PAID_CARD_NUMBER")
	private String foodOrderPaidCardNumber;

	@Column(name="FOOD_ORDER_PAID_IND")
	private String foodOrderPaidInd;

	@Column(name="RESTAURANTS_ID")
	private int restaurantsId;

	@Column(name="RESTAURANTS_NAME")
	private String restaurantsName;

	//bi-directional many-to-one association to Customer
/*	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;*/

	//bi-directional many-to-one association to FoodOrderMenuItem
	@OneToMany(mappedBy="foodOrder")
	private List<FoodOrderMenuItem> foodOrderMenuItems;

	//bi-directional many-to-one association to FoodOrderTable
	@OneToMany(mappedBy="foodOrder")
	private List<FoodOrderTable> foodOrderTables;

	public FoodOrder() {
	}

	public int getIdFOOD_ORDER() {
		return this.idFOOD_ORDER;
	}

	public void setIdFOOD_ORDER(int idFOOD_ORDER) {
		this.idFOOD_ORDER = idFOOD_ORDER;
	}

	public String getFoodOrderCreatedDate() {
		return this.foodOrderCreatedDate;
	}

	public void setFoodOrderCreatedDate(String foodOrderCreatedDate) {
		this.foodOrderCreatedDate = foodOrderCreatedDate;
	}

	public float getFoodOrderFinalTotPrice() {
		return this.foodOrderFinalTotPrice;
	}

	public void setFoodOrderFinalTotPrice(float foodOrderFinalTotPrice) {
		this.foodOrderFinalTotPrice = foodOrderFinalTotPrice;
	}

	public String getFoodOrderLastmodifiedDate() {
		return this.foodOrderLastmodifiedDate;
	}

	public void setFoodOrderLastmodifiedDate(String foodOrderLastmodifiedDate) {
		this.foodOrderLastmodifiedDate = foodOrderLastmodifiedDate;
	}

	public String getFoodOrderPaidCardNumber() {
		return this.foodOrderPaidCardNumber;
	}

	public void setFoodOrderPaidCardNumber(String foodOrderPaidCardNumber) {
		this.foodOrderPaidCardNumber = foodOrderPaidCardNumber;
	}

	public String getFoodOrderPaidInd() {
		return this.foodOrderPaidInd;
	}

	public void setFoodOrderPaidInd(String foodOrderPaidInd) {
		this.foodOrderPaidInd = foodOrderPaidInd;
	}

	public int getRestaurantsId() {
		return this.restaurantsId;
	}

	public void setRestaurantsId(int restaurantsId) {
		this.restaurantsId = restaurantsId;
	}

	public String getRestaurantsName() {
		return this.restaurantsName;
	}

	public void setRestaurantsName(String restaurantsName) {
		this.restaurantsName = restaurantsName;
	}

	/*public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}*/

	public List<FoodOrderMenuItem> getFoodOrderMenuItems() {
		return this.foodOrderMenuItems;
	}

	public void setFoodOrderMenuItems(List<FoodOrderMenuItem> foodOrderMenuItems) {
		this.foodOrderMenuItems = foodOrderMenuItems;
	}

	public FoodOrderMenuItem addFoodOrderMenuItem(FoodOrderMenuItem foodOrderMenuItem) {
		getFoodOrderMenuItems().add(foodOrderMenuItem);
		foodOrderMenuItem.setFoodOrder(this);

		return foodOrderMenuItem;
	}

	public FoodOrderMenuItem removeFoodOrderMenuItem(FoodOrderMenuItem foodOrderMenuItem) {
		getFoodOrderMenuItems().remove(foodOrderMenuItem);
		foodOrderMenuItem.setFoodOrder(null);

		return foodOrderMenuItem;
	}

	public List<FoodOrderTable> getFoodOrderTables() {
		return this.foodOrderTables;
	}

	public void setFoodOrderTables(List<FoodOrderTable> foodOrderTables) {
		this.foodOrderTables = foodOrderTables;
	}

	public FoodOrderTable addFoodOrderTable(FoodOrderTable foodOrderTable) {
		getFoodOrderTables().add(foodOrderTable);
		foodOrderTable.setFoodOrder(this);

		return foodOrderTable;
	}

	public FoodOrderTable removeFoodOrderTable(FoodOrderTable foodOrderTable) {
		getFoodOrderTables().remove(foodOrderTable);
		foodOrderTable.setFoodOrder(null);

		return foodOrderTable;
	}

}