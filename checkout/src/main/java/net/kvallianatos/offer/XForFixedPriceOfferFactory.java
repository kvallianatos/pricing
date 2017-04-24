package net.kvallianatos.offer;

public class XForFixedPriceOfferFactory implements OfferFactory<XForFixedPriceOffer> {
	
	@Override
	public XForFixedPriceOffer newInstance(OfferDetails offerdetails) {
		return new XForFixedPriceOffer(offerdetails);
	}
}

