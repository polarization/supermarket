package com.cienet.ftt.supermarket;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderChecker {

	private Set<Promotion> set = new HashSet<Promotion>();
	private List<Checkable<?>> possibleCheck = new ArrayList<Checkable<?>>();

	public OrderChecker(Set<Promotion> set) {
		this.set = set;
	}

	public int checkout(Order order) {
		collectPossibleCheck(order);
		int minCost = -1;
		for (Checkable<?> checkable : possibleCheck) {
			int cost = checkable.checkout();
			minCost = (minCost < cost && minCost != -1) ? minCost : cost;
		}
		return minCost;
	}

	private void collectPossibleCheck(Checkable<?> checkable) {
		Set<Promotion> copiedSet = getCopiedPromotionSet();
		List<Checkable<Promotion>> filtedPromotions = setupDecoratorNode(
				checkable, copiedSet);
		for (Checkable<Promotion> promotion : filtedPromotions) {
			collectPossibleCheck(promotion);
		}
	}

	private List<Checkable<Promotion>> setupDecoratorNode(
			Checkable<?> checkable, Set<Promotion> copiedSet) {
		List<Checkable<Promotion>> filtedPromotions = new ArrayList<Checkable<Promotion>>();
		boolean fitPromotion = false;
		for (Promotion promotion : copiedSet) {
			Checkable<?> copy = checkable.copy();
			if (promotion.isEnable(copy)) {
				promotion.setCheckable(copy);
				filtedPromotions.add(promotion);
				fitPromotion = true;
			}
		}
		if (!fitPromotion) {
			possibleCheck.add(checkable.copy());
		}
		return filtedPromotions;
	}

	private Set<Promotion> getCopiedPromotionSet() {
		Set<Promotion> copiedSet = new HashSet<Promotion>();
		for (Promotion promotion : set) {
			copiedSet.add(promotion.copy());
		}
		return copiedSet;
	}

}
