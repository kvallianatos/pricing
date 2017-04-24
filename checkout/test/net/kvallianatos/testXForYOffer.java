package net.kvallianatos;

import net.kvallianatos.offer.OfferDetails;
import net.kvallianatos.offer.OfferType;
import net.kvallianatos.offer.XForYOffer;
import net.kvallianatos.pricing.entity.ShoppingCart;
import net.kvallianatos.pricing.entity.UnitItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class testXForYOffer {

	@Test
	public void testFourForTwo() {
		OfferDetails offerDetails = new OfferDetails();
		offerDetails.setType(OfferType.XForYPrice);
		offerDetails.setX(4);
		offerDetails.setY(2);

		ShoppingCart cart = createStaticCart();
		XForYOffer offer = new XForYOffer(offerDetails);

		assertFalse("Offer should not be applicable", offer.isApplicable(cart, "Coke"));
		assertTrue("Offer should be applicable", offer.isApplicable(cart, "Beans"));
		assertEquals("Incorrect price adjustment", BigDecimal.valueOf(-3.98), offer.applyOffer(cart, "Beans"));

	}

	private ShoppingCart createStaticCart() {
		ShoppingCart cart = new ShoppingCart();

		cart.getCartItems().put("Beans", new ArrayList<>());
		cart.getCartItems().put("Coke", new ArrayList<>());
		cart.getCartItems().put("Milk", new ArrayList<>());

		cart.getCartItems().get("Beans").add(new UnitItem("Beans", BigDecimal.valueOf(1.99)));
		cart.getCartItems().get("Beans").add(new UnitItem("Beans", BigDecimal.valueOf(1.99)));
		cart.getCartItems().get("Beans").add(new UnitItem("Beans", BigDecimal.valueOf(1.99)));
		cart.getCartItems().get("Beans").add(new UnitItem("Beans", BigDecimal.valueOf(1.99)));
		cart.getCartItems().get("Coke").add(new UnitItem("Coke", BigDecimal.valueOf(0.99)));
		cart.getCartItems().get("Milk").add(new UnitItem("Milk", BigDecimal.valueOf(1.20)));
		cart.getCartItems().get("Milk").add(new UnitItem("Milk", BigDecimal.valueOf(1.20)));
		cart.getCartItems().get("Milk").add(new UnitItem("Milk", BigDecimal.valueOf(1.20)));

		return cart;
	}
}
