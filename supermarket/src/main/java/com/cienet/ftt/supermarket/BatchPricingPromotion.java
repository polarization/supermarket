package com.cienet.ftt.supermarket;

public class BatchPricingPromotion implements Promotion {

	private Product product;
	private int batchSize;
	private int batchPrice;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batchPrice;
		result = prime * result + batchSize;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BatchPricingPromotion other = (BatchPricingPromotion) obj;
		if (batchPrice != other.batchPrice)
			return false;
		if (batchSize != other.batchSize)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

	public int checkout(Order order) {
		return batchPrice * (order.getQuantity() / batchSize)
				+ (order.getQuantity() % batchSize)
				* order.getProduct().getPrice();
	}

}
