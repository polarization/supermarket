package com.cienet.ftt.supermarket;

public class NonePromotionManager implements PromotionManager {

	public void manage(Promotion promotion) {
	}

	public int checkout(Order order) {
		return order.checkout();
	}

}
