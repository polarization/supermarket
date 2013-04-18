package com.cienet.ftt.supermarket;

import java.util.HashSet;
import java.util.Set;

public class NormalPromotionManager implements PromotionManager {
	private Set<Promotion> set = new HashSet<Promotion>();

	public void manage(Promotion promotion) {
		set.add(promotion);
	}

	public int checkout(Order order) {
		for (Promotion promotion : set) {
			if (promotion.isEnable(order)) {
				return promotion.checkout(order);
			}
		}
		return order.checkout();
	}

}
