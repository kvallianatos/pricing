package net.kvallianatos.pricing.service;

import net.kvallianatos.pricing.entity.Item;
import net.kvallianatos.pricing.entity.ShoppingCart;

import java.math.BigDecimal;
import java.util.List;

public class CheckoutService {

	public BigDecimal handleCheckout(final ShoppingCart cart) {
		BigDecimal runningTotalCost = BigDecimal.ZERO;

		runningTotalCost = runningTotalCost.add(calculateBaseCost(cart));

		return runningTotalCost;
	}

	private BigDecimal calculateBaseCost(final ShoppingCart cart) {
		BigDecimal baseCost = BigDecimal.ZERO;

		for(List<Item> itemsOfType: cart.getCartItems().values()) {
			for (Item item: itemsOfType) {
				baseCost = baseCost.add(item.getPrice());
			}
		}
		return baseCost;
	}
}
