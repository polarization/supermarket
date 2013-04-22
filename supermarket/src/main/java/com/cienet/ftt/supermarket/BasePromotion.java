package com.cienet.ftt.supermarket;

public abstract class BasePromotion implements Promotion {

	protected Product product;
	protected Checkable<?> checkable;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getUncheckQuantity() {
		return checkable.getUncheckQuantity();
	}

	public void setUncheckQuantity(int uncheck) {
		checkable.setUncheckQuantity(uncheck);
	}

	public Promotion copy() {
		BasePromotion copy = setupCopy();
		if (checkable != null) {
			copy.setCheckable(checkable.copy());
		}
		return copy;
	}

	protected abstract BasePromotion setupCopy();

	public boolean isEnable(Checkable<?> checkable) {
		return product.equals(checkable.getProduct());
	}

	public void setCheckable(Checkable<?> checkable) {
		this.checkable = checkable;
	}

}
