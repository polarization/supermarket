package com.cienet.ftt.supermarket;

public class BatchPricingPromotion extends BasePromotion {

	private int batchSize;
	private int batchPrice;

	public BatchPricingPromotion(Product product, int batchSize, int batchPrice) {
		super();
		this.product = product;
		this.batchSize = batchSize;
		this.batchPrice = batchPrice;
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

	public int checkout() {
		return batchPrice + checkable.checkout();
	}

	public boolean isEnable(Checkable<?> checkable) {
		return batchSize <= checkable.getUncheckQuantity()
				&& super.isEnable(checkable);
	}

	public void setCheckable(Checkable<?> checkable) {
		super.setCheckable(checkable);
		this.checkable.setUncheckQuantity(checkable.getUncheckQuantity()
				- batchSize);
	}

	@Override
	protected BasePromotion setupCopy() {
		return new BatchPricingPromotion(product, batchSize, batchPrice);
	}

}
