package net.kvallianatos.offer;

public interface OfferFactory<T> {
	T newInstance(OfferDetails offerdetails);
}
