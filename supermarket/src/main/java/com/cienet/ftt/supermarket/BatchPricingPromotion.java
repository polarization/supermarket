package com.cienet.ftt.supermarket;

public class BatchPricingPromotion implements Promotion {

	private Product product;
	private int batchSize;
	private int batchPrice;
	private Checkable checkable;

	public BatchPricingPromotion(Product product, int batchSize, int batchPrice) {
		super();
		this.product = product;
		this.batchSize = batchSize;
		this.batchPrice = batchPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

	public int getBatchPrice() {
		return batchPrice;
	}

	public void setBatchPrice(int batchPrice) {
		this.batchPrice = batchPrice;
	}

	public BatchPricingPromotion() {
		super();
	}

	public boolean isEnable(Order order) {
		return batchSize < order.getQuantity();
	}

	public int checkout() {
		return batchPrice + checkable.checkout();
	}

	public int getUncheckQuantity() {
		return checkable.getUncheckQuantity();
	}

	public void setUncheckQuantity(int uncheck) {
		checkable.setUncheckQuantity(uncheck);
	}

	public boolean isEnable(Checkable checkable) {
		return batchSize <= checkable.getUncheckQuantity()
				&& product.equals(checkable.getProduct());
	}

	public void setCheckable(Checkable checkable) {
		this.checkable = checkable;
		this.checkable.setUncheckQuantity(checkable.getUncheckQuantity()
				- batchSize);
	}

	public Promotion copy() {
		BatchPricingPromotion copy = new BatchPricingPromotion(product,
				batchSize, batchPrice);
		if (checkable != null) {
			copy.setCheckable(checkable.copy());
		}
		return copy;
	}
}
