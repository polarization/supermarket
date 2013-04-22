package com.cienet.ftt.supermarket;

public interface Checkable {
	public int checkout();
	public int getUncheckQuantity();
	public void setUncheckQuantity(int uncheck);
	public Checkable copy();
	public Product getProduct();
}
