package net.kvallianatos;

import net.kvallianatos.pricing.entity.Item;
import net.kvallianatos.pricing.entity.ShoppingCart;
import net.kvallianatos.pricing.service.CheckoutService;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class testPricingEngine {

	/**
	 * Test that the implementation correctly calculates the total cost of the items in a shopping cart.
	 * This is the base scenario with no active offers and items with unit pricing.
	 */
	@Test
	public void testCalculateShoppingCartCost() {
		ShoppingCart cart = createStaticCart();
		assertEquals("Incorrect final charge calculated", BigDecimal.valueOf(7.37), new CheckoutService().handleCheckout(cart));

		TestingCartTuple cartTuple = createRandomCart(1000);
		assertEquals("Incorrect final charge calculated", cartTuple.total, new CheckoutService().handleCheckout(cartTuple.cart));
	}

	private ShoppingCart createStaticCart() {
		ShoppingCart cart = new ShoppingCart();

		cart.getCartItems().put("Beans", new ArrayList<>());
		cart.getCartItems().put("Coke", new ArrayList<>());
		cart.getCartItems().put("Milk", new ArrayList<>());

		cart.getCartItems().get("Beans").add(new Item("Beans", BigDecimal.valueOf(1.99)));
		cart.getCartItems().get("Beans").add(new Item("Beans", BigDecimal.valueOf(1.99)));
		cart.getCartItems().get("Coke").add(new Item("Coke", BigDecimal.valueOf(0.99)));
		cart.getCartItems().get("Milk").add(new Item("Milk", BigDecimal.valueOf(1.20)));
		cart.getCartItems().get("Milk").add(new Item("Milk", BigDecimal.valueOf(1.20)));

		return cart;
	}

	private TestingCartTuple createRandomCart(int numItems) {
		Random r = new Random();
		BigDecimal total = BigDecimal.ZERO;

		String[] itemTypes = {"Beans", "Coke", "Milk", "Orange juice", "Eggs", "Flour", "Avocado", "Wine"};
		Map<String, BigDecimal> itemPrices = new HashMap<>();
		for (int i = 0; i < itemTypes.length; i++) {
			itemPrices.put(itemTypes[i], BigDecimal.valueOf(r.nextDouble() * (double)r.nextInt(10)).setScale(2, BigDecimal.ROUND_DOWN));
		}

		TestingCartTuple cartTuple = new TestingCartTuple();
		ShoppingCart cart = new ShoppingCart();

		for(int i = 0; i < numItems; i++) {
			String itemType = itemTypes[r.nextInt(itemTypes.length)];
			total = total.add(itemPrices.get(itemType));

			if (cart.getCartItems().containsKey(itemType)) {
				cart.getCartItems().get(itemType).add(new Item(itemType, itemPrices.get(itemType)));
			} else {
				ArrayList<Item> itemList = new ArrayList<>();
				itemList.add(new Item(itemType, itemPrices.get(itemType)));
				cart.getCartItems().put(itemType, itemList);
			}
		}

		cartTuple.total = total;
		cartTuple.cart = cart;
		return cartTuple;
	}

	class TestingCartTuple {
		BigDecimal total;
		ShoppingCart cart;
	}
}
