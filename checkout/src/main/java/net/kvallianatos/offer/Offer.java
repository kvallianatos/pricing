package net.kvallianatos.offer;

import net.kvallianatos.pricing.entity.ShoppingCart;

import java.math.BigDecimal;

public interface Offer {

	BigDecimal applyOffer(ShoppingCart cart, String itemType);

	boolean isApplicable(ShoppingCart cart, String itemType);
}
