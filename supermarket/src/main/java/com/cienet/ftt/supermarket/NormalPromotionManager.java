package com.cienet.ftt.supermarket;

import java.util.HashSet;
import java.util.Set;

public class NormalPromotionManager implements PromotionManager {
	private Set<Promotion> set = new HashSet<Promotion>();

	public void manage(Promotion promotion) {
		set.add(promotion);
	}

	public int checkout(Order order) {
		return new OrderChecker(set).checkout(order);
	}

}
