package net.kvallianatos.offer;

import java.util.HashMap;
import java.util.Map;

public class OfferFactoryController {

	private Map<OfferType, OfferFactory<? extends Offer>> factories = new HashMap<>();

	public OfferFactoryController() {

		factories.put(OfferType.XForYPrice, new XForYOfferFactory());
		factories.put(OfferType.XForFixedPrice, new XForFixedPriceOfferFactory());
	}

	public Offer createOffer(OfferDetails details) {
		return factories.get(details.getType()).newInstance(details);
	}
}
