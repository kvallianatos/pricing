package net.kvallianatos.pricing.service;

import net.kvallianatos.offer.MockOfferService;
import net.kvallianatos.offer.Offer;
import net.kvallianatos.offer.OfferDetails;
import net.kvallianatos.offer.OfferFactoryController;
import net.kvallianatos.pricing.entity.Item;
import net.kvallianatos.pricing.entity.ShoppingCart;

import java.math.BigDecimal;
import java.util.List;

public class CheckoutServiceImpl implements CheckoutService {

	private OfferFactoryController offerFactoryController;

	public CheckoutServiceImpl () {
		// Would normally be handled by dependency injection, but handled this way to avoid having to use Mockito in tests
		this.offerFactoryController = new OfferFactoryController();
	}

	@Override
	public BigDecimal handleCheckout(final ShoppingCart cart) {
		BigDecimal runningTotalCost = BigDecimal.ZERO;

		runningTotalCost = runningTotalCost.add(calculateBaseCost(cart));
		runningTotalCost = runningTotalCost.add(applyOffers(cart));

		System.out.println("Total to pay: " + runningTotalCost.toString());
		return runningTotalCost;
	}

	private BigDecimal calculateBaseCost(final ShoppingCart cart) {
		BigDecimal baseCost = BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);

		for(List<Item> itemsOfType: cart.getCartItems().values()) {
			for (Item item: itemsOfType) {
				baseCost = baseCost.add(item.getPrice());
			}
		}
		return baseCost;
	}

	@Override
	public BigDecimal applyOffers(final ShoppingCart cart) {
		BigDecimal adjustment = BigDecimal.ZERO;
		for(String itemType: cart.getCartItems().keySet()) {
			OfferDetails offerDetails = MockOfferService.getActiveOffer(itemType);
			if (offerDetails.getType() != null) {
				Offer offer = offerFactoryController.createOffer(offerDetails);
				while (offer.isApplicable(cart, itemType)) {
					System.out.println("Applying offer for: " + itemType);
					adjustment = adjustment.add(offer.applyOffer(cart, itemType));
				}
			}
		}
		System.out.println("Adjustment is: " + adjustment.toString());
		return adjustment;
	}
}
