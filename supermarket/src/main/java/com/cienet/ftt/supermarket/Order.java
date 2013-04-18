package com.cienet.ftt.supermarket;

public class Order {
	private Product product;
	private int quantity;

	public Order(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public Order() {
		super();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int checkout() {
		return product.getPrice() * quantity;
	}

}
