package net.kvallianatos.pricing.entity;

import java.math.BigDecimal;

public class UnitItem extends Item {

	private BigDecimal price;

	public UnitItem(String type, BigDecimal price) {
		super(type);
		this.price = price;
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}
}
