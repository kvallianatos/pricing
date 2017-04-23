package net.kvallianatos.pricing.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

	private final Map<String, ArrayList<Item>> cartItems = new HashMap<>();
	private final List<Item> processedItems = new ArrayList<>();

	public Map<String, ArrayList<Item>> getCartItems() {
		return cartItems;
	}

	public List<Item> getProcessedItems() {
		return processedItems;
	}

}
