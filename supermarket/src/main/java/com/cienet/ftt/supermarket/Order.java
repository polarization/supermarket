package com.cienet.ftt.supermarket;

public class Order implements Checkable<Order> {

	private Product product;
	private int quantity;
	private int uncheck;

	public Order(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.uncheck = quantity;
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
		return product.getPrice() * uncheck;
	}

	public int getUncheckQuantity() {
		return uncheck;
	}

	public void setUncheckQuantity(int uncheck) {
		this.uncheck = uncheck;
	}

	public Order copy() {
		Order order = new Order(product, quantity);
		return order;
	}

}
