package net.kvallianatos.pricing.service;

import net.kvallianatos.pricing.entity.ShoppingCart;

import java.math.BigDecimal;

/**
 * Public interface for the checkout service
 */
public interface CheckoutService {
	BigDecimal handleCheckout(final ShoppingCart cart);
	BigDecimal applyOffers(final ShoppingCart cart);
}
