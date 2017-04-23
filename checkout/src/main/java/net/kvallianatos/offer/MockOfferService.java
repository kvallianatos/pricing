package net.kvallianatos.offer;

public class MockOfferService {

	public static OfferDetails getActiveOffer(String itemType) {
		OfferDetails offerDetails = new OfferDetails();

		switch (itemType) {
			case "Muffins":
				offerDetails.setType(OfferType.XForYPrice);
				offerDetails.setX(3);
				offerDetails.setY(2);
				break;
			default:
				break;
		}

		return offerDetails;
	}

}
