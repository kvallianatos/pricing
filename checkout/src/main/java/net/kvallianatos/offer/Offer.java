package net.kvallianatos.offer;

import net.kvallianatos.pricing.entity.ShoppingCart;

import java.math.BigDecimal;

/**
 * Interface used to define API for offers
 */
public interface Offer {

	/**
	 * Applies the offer to the items in the shopping cart for the given item type
	 * @param cart
	 * @param itemType
	 * @return The total adjustment required after applying this offer
	 */
	BigDecimal applyOffer(ShoppingCart cart, String itemType);

	/**
	 * Checks if the shopping cart contains the correct types and amounts of items
	 * for this offer
	 *
	 * @param cart
	 * @param itemType
	 * @return true if offer can be applied to items in shopping cart
	 */
	boolean isApplicable(ShoppingCart cart, String itemType);
}
