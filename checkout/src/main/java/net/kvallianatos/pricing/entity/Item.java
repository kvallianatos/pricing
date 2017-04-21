package net.kvallianatos.pricing.entity;

import java.math.BigDecimal;

public class Item {

	private String itemType;
	private BigDecimal price;

	public Item(String type, BigDecimal price) {
		this.itemType = type;
		this.price = price;
	}

	public String getItemType() {
		return itemType;
	}

	void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	void setPrice(BigDecimal price) {
		this.price = price;
	}
}
