package net.kvallianatos.pricing.entity;

import java.math.BigDecimal;

public abstract class Item {

	private String itemType;


	public Item(String type) {
		this.itemType = type;
	}

	public String getItemType() {
		return itemType;
	}

	public abstract BigDecimal getPrice();
}
