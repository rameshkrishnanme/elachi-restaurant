package com.blacksystemse.spring.boot.microservices.elachi.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the food_order_menu_item database table.
 * 
 */
@Entity
@Table(name="food_order_menu_item")
@NamedQuery(name="FoodOrderMenuItem.findAll", query="SELECT f FROM FoodOrderMenuItem f")
public class FoodOrderMenuItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idFOOD_ORDER_MENU_ITEM;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FOOD_ORDER_MENU_CREATED_DATE")
	private Date foodOrderMenuCreatedDate;

	@Column(name="FOOD_ORDER_MENU_IND_PRICE")
	private float foodOrderMenuIndPrice;

	@Column(name="FOOD_ORDER_MENU_ITEM_NAME")
	private String foodOrderMenuItemName;

	@Column(name="FOOD_ORDER_MENU_ITEM_QUANTITY")
	private int foodOrderMenuItemQuantity;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FOOD_ORDER_MENU_LASTMODIFIED_DATE")
	private Date foodOrderMenuLastmodifiedDate;

	@Column(name="FOOD_ORDER_MENU_TOT_PRICE")
	private float foodOrderMenuTotPrice;

	//bi-directional many-to-one association to FoodOrder
	@ManyToOne
	@JoinColumn(name="FOOD_ORDER_ID")
	private FoodOrder foodOrder;

	public FoodOrderMenuItem() {
	}

	public int getIdFOOD_ORDER_MENU_ITEM() {
		return this.idFOOD_ORDER_MENU_ITEM;
	}

	public void setIdFOOD_ORDER_MENU_ITEM(int idFOOD_ORDER_MENU_ITEM) {
		this.idFOOD_ORDER_MENU_ITEM = idFOOD_ORDER_MENU_ITEM;
	}

	public Date getFoodOrderMenuCreatedDate() {
		return this.foodOrderMenuCreatedDate;
	}

	public void setFoodOrderMenuCreatedDate(Date foodOrderMenuCreatedDate) {
		this.foodOrderMenuCreatedDate = foodOrderMenuCreatedDate;
	}

	public float getFoodOrderMenuIndPrice() {
		return this.foodOrderMenuIndPrice;
	}

	public void setFoodOrderMenuIndPrice(float foodOrderMenuIndPrice) {
		this.foodOrderMenuIndPrice = foodOrderMenuIndPrice;
	}

	public String getFoodOrderMenuItemName() {
		return this.foodOrderMenuItemName;
	}

	public void setFoodOrderMenuItemName(String foodOrderMenuItemName) {
		this.foodOrderMenuItemName = foodOrderMenuItemName;
	}

	public int getFoodOrderMenuItemQuantity() {
		return this.foodOrderMenuItemQuantity;
	}

	public void setFoodOrderMenuItemQuantity(int foodOrderMenuItemQuantity) {
		this.foodOrderMenuItemQuantity = foodOrderMenuItemQuantity;
	}

	public Date getFoodOrderMenuLastmodifiedDate() {
		return this.foodOrderMenuLastmodifiedDate;
	}

	public void setFoodOrderMenuLastmodifiedDate(Date foodOrderMenuLastmodifiedDate) {
		this.foodOrderMenuLastmodifiedDate = foodOrderMenuLastmodifiedDate;
	}

	public float getFoodOrderMenuTotPrice() {
		return this.foodOrderMenuTotPrice;
	}

	public void setFoodOrderMenuTotPrice(float foodOrderMenuTotPrice) {
		this.foodOrderMenuTotPrice = foodOrderMenuTotPrice;
	}

	public FoodOrder getFoodOrder() {
		return this.foodOrder;
	}

	public void setFoodOrder(FoodOrder foodOrder) {
		this.foodOrder = foodOrder;
	}

}