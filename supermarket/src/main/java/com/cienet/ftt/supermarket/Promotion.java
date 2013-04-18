package com.cienet.ftt.supermarket;

public interface Promotion {
	public boolean isEnable(Order order);

	public int checkout(Order order);
}
