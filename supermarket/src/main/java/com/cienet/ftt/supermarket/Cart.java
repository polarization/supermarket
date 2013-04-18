package com.cienet.ftt.supermarket;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<String, Order> orderMap = new HashMap<String, Order>();

	public void add(Order order) {
		String name = order.getProduct().getName();
		if (orderMap.containsKey(name)) {
			Order newOrder = new Order(order.getProduct(), order.getQuantity()
					+ orderMap.get(name).getQuantity());
			orderMap.put(name, newOrder);
		} else {
			orderMap.put(name, order);
		}
	}

	public int checkout() {
		int sum = 0;
		for (Map.Entry<String, Order> entry : orderMap.entrySet()) {
			Order order = entry.getValue();
			sum += order.checkout();
		}
		return sum;
	}

	public int getSize() {
		return orderMap.size();
	}

	public Order getOrder(String name) {
		return orderMap.get(name);
	}
}
