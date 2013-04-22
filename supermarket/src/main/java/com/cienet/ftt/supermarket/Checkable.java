package com.cienet.ftt.supermarket;

public interface Checkable<T extends Checkable<?>> {
	public int checkout();

	public int getUncheckQuantity();

	public void setUncheckQuantity(int uncheck);

	public T copy();

	public Product getProduct();
}
