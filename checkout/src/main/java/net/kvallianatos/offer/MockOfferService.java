package net.kvallianatos.offer;

import java.math.BigDecimal;

/**
 * Mock class used to model an external service used to retrieve offers
 */
public class MockOfferService {

	public static OfferDetails getActiveOffer(String itemType) {
		OfferDetails offerDetails = new OfferDetails();

		switch (itemType) {
			case "Muffins":
				offerDetails.setType(OfferType.XForYPrice);
				offerDetails.setX(3);
				offerDetails.setY(2);
				break;
			case "Pork pie":
				offerDetails.setType(OfferType.XForFixedPrice);
				offerDetails.setX(2);
				offerDetails.setFixedPrice(BigDecimal.valueOf(3.0).setScale(2, BigDecimal.ROUND_HALF_UP));
			default:
				break;
		}

		return offerDetails;
	}

}
