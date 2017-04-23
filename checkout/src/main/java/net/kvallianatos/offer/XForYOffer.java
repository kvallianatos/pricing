package net.kvallianatos.offer;

import net.kvallianatos.pricing.entity.Item;
import net.kvallianatos.pricing.entity.ShoppingCart;

import java.math.BigDecimal;

public class XForYOffer implements Offer {

	private int x,y;

	public XForYOffer(OfferDetails offerdetails) {
		super();
		this.x = offerdetails.getX();
		this.y = offerdetails.getY();
	}

	@Override
	public BigDecimal applyOffer(ShoppingCart cart, String itemType) {
		BigDecimal adjustment = BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);
		for (int i = 0; i < x; i++) {
			Item item = cart.getCartItems().get(itemType).get(0);
			cart.getProcessedItems().add(item);
			cart.getCartItems().get(itemType).remove(item);
			if (i >= y) {
				adjustment = adjustment.subtract(item.getPrice());
			}
		}

		return adjustment;
	}

	@Override
	public boolean isApplicable(ShoppingCart cart, String itemType) {
		if (cart.getCartItems().containsKey(itemType)) {
			return cart.getCartItems().get(itemType).size() >= x;
		}

		return false;
	}
}
