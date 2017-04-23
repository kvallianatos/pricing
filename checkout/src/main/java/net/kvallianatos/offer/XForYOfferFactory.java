package net.kvallianatos.offer;

public class XForYOfferFactory implements OfferFactory<XForYOffer> {

	@Override
	public XForYOffer newInstance(OfferDetails offerdetails) {
		return new XForYOffer(offerdetails);
	}
}
