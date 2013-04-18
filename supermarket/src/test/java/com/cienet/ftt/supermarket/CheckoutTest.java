package com.cienet.ftt.supermarket;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckoutTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSimpleCart() {
		Product a = new Product("A", 2);
		Product b = new Product("B", 3);
		Cart cart = new Cart();
		Order order1 = new Order(a, 5);
		Order order2 = new Order(b, 3);
		cart.add(order1);
		cart.add(order2);
		assertEquals(19, cart.checkout());
	}
	
	@Test
	public void testCartMerge() {
		Product a = new Product("A", 2);
		Cart cart = new Cart();
		Order order1 = new Order(a, 5);
		Order order2 = new Order(a, 3);
		cart.add(order1);
		cart.add(order2);
		assertEquals(1, cart.getSize());
		assertEquals(8, cart.getOrder("A").getQuantity());
	}
}
