package net.kvallianatos.pricing.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

	private final Map<String, ArrayList<Item>> cartItems = new HashMap<>();

	public Map<String, ArrayList<Item>> getCartItems() {
		return cartItems;
	}
}
