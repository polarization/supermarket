package com.cienet.ftt.supermarket;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NormalPromotionManager implements PromotionManager {
	private Set<Promotion> set = new HashSet<Promotion>();
	private List<Checkable> possibleCheck = new ArrayList<Checkable>();

	public void manage(Promotion promotion) {
		set.add(promotion);
	}

	public int checkout(Order order) {
		collectPossibleCheck(order);
		int minCost = -1;
		for (Checkable checkable : possibleCheck) {
			int cost = checkable.checkout();
			minCost = (minCost < cost && minCost != -1) ? minCost : cost;
		}
		return minCost;
	}

	private void collectPossibleCheck(Checkable checkable) {
		List<Checkable> filtedPromotions = new ArrayList<Checkable>();
		boolean fitPromotion = false;
		Set<Promotion> copiedSet = new HashSet<Promotion>();
		for (Promotion promotion : set) {
			copiedSet.add((Promotion) promotion.copy());
		}
		for (Promotion promotion : copiedSet) {
			Checkable copy = checkable.copy();
			if (promotion.isEnable(copy)) {
				promotion.setCheckable(copy);
				filtedPromotions.add(promotion);
				fitPromotion = true;
			}
		}
		if (!fitPromotion) {
			possibleCheck.add(checkable.copy());
		}
		for (Checkable promotion : filtedPromotions) {
			collectPossibleCheck(promotion);
		}
	}

}
