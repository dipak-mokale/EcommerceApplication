package com.velocity.ecommerceapp;

public class Cart {
	private int ID;
	private String Name;
	private int Quantity;
	private int price;
	
	public Cart() {
		super();
	}
	public Cart(Integer idInteger, String nameString, int quantityString,int price) {
		super();
		this.ID = idInteger;
		this.Name = nameString;
		this.Quantity = quantityString;
		this.price = price;
	}
	public Integer getID() {
		return ID;
	}
	public void setIdInteger(Integer ID) {
		this.ID = ID;
	}
	public String getNameString() {
		return Name;
	}
	public void setNameString(String nameString) {
		this.Name = nameString;
	}
	public int getQuantityString() {
		return Quantity;
	}
	public void setQuantityString(int quantityString) {
		this.Quantity = quantityString;
	}
	@Override
	public String toString() {
		return "Cart [ID=" + ID + ", Name=" + Name + ", Quantity=" + Quantity + ", Price =" + price+"]";
	}
	
	
}
