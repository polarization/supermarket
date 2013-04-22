package com.cienet.ftt.supermarket;

public interface Promotion extends Checkable {
	public boolean isEnable(Checkable checkable);

	public void setCheckable(Checkable checkable);
}
