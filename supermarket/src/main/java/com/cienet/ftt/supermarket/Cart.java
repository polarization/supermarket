package com.cienet.ftt.supermarket;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Order> list = new ArrayList<Order>();

	public void add(Order order) {
		list.add(order);
	}

	public int checkout() {
		int sum = 0;
		for (Order order : list) {
			sum += order.getProduct().getPrice() * order.getQuantity();
		}
		return sum;
	}
}
