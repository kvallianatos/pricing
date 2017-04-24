package net.kvallianatos.pricing.entity;

import java.math.BigDecimal;

public class WeightBasedItem extends Item {

	private double weight;
	private BigDecimal price;

	public WeightBasedItem(String type, BigDecimal price, double weight) {
		super(type);
		this.price = price;
		this.weight = weight;
	}

	@Override
	public BigDecimal getPrice() {
		return price.multiply(BigDecimal.valueOf(weight)).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
