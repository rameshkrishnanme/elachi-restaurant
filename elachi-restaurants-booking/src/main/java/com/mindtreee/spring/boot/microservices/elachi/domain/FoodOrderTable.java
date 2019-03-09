package com.mindtreee.spring.boot.microservices.elachi.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the food_order_table database table.
 * 
 */
@Entity
@Table(name="food_order_table")
@NamedQuery(name="FoodOrderTable.findAll", query="SELECT f FROM FoodOrderTable f")
public class FoodOrderTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idFOOD_ORDER_TABLE;

	@Column(name="FOOD_ORDER_PRICE")
	private String foodOrderPrice;

	@Column(name="FOOD_ORDER_TABLE_NAME")
	private String foodOrderTableName;

	@Column(name="RESTAURANTS_TABLE_ID")
	private String restaurantsTableId;

	//bi-directional many-to-one association to FoodOrder
	@ManyToOne
	@JoinColumn(name="FOOD_ORDER_ID")
	private FoodOrder foodOrder;

	public FoodOrderTable() {
	}

	public int getIdFOOD_ORDER_TABLE() {
		return this.idFOOD_ORDER_TABLE;
	}

	public void setIdFOOD_ORDER_TABLE(int idFOOD_ORDER_TABLE) {
		this.idFOOD_ORDER_TABLE = idFOOD_ORDER_TABLE;
	}

	public String getFoodOrderPrice() {
		return this.foodOrderPrice;
	}

	public void setFoodOrderPrice(String foodOrderPrice) {
		this.foodOrderPrice = foodOrderPrice;
	}

	public String getFoodOrderTableName() {
		return this.foodOrderTableName;
	}

	public void setFoodOrderTableName(String foodOrderTableName) {
		this.foodOrderTableName = foodOrderTableName;
	}

	public String getRestaurantsTableId() {
		return this.restaurantsTableId;
	}

	public void setRestaurantsTableId(String restaurantsTableId) {
		this.restaurantsTableId = restaurantsTableId;
	}

	public FoodOrder getFoodOrder() {
		return this.foodOrder;
	}

	public void setFoodOrder(FoodOrder foodOrder) {
		this.foodOrder = foodOrder;
	}

}