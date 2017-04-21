package net.kvallianatos;

import net.kvallianatos.pricing.entity.Item;
import net.kvallianatos.pricing.entity.ShoppingCart;
import net.kvallianatos.pricing.service.CheckoutService;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class testPricingEngine {

	/**
	 * Test that the implementation correctly calculates the total cost of the items in a shopping cart.
	 * This is the base scenario with no active offers and items with unit pricing.
	 */
	@Test
	public void testCalculateShoppingCartCost() {
		ShoppingCart cart = createCart(3);

		assertEquals("Incorrect final charge calculated", BigDecimal.valueOf(4.18), new CheckoutService().handleCheckout(cart));
	}

	private ShoppingCart createCart(int numItems) {
		ShoppingCart cart = new ShoppingCart();

		for(int i = 0; i < numItems; i++) {
			cart.getCartItems().put("Beans", new ArrayList<>());
			cart.getCartItems().put("Coke", new ArrayList<>());
			cart.getCartItems().put("Milk", new ArrayList<>());

			cart.getCartItems().get("Beans").add(new Item("Beans", BigDecimal.valueOf(1.99)));
			cart.getCartItems().get("Coke").add(new Item("Coke", BigDecimal.valueOf(0.99)));
			cart.getCartItems().get("Milk").add(new Item("Milk", BigDecimal.valueOf(1.20)));
		}

		return cart;
	}
}
