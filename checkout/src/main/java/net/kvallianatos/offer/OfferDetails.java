package net.kvallianatos.offer;


import java.math.BigDecimal;

public class OfferDetails {

	private OfferType type;
	private int x;
	private int y;
	private BigDecimal fixedPrice;

	public OfferType getType() {
		return type;
	}

	public void setType(OfferType type) {
		this.type = type;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public BigDecimal getFixedPrice() {
		return fixedPrice;
	}

	public void setFixedPrice(BigDecimal fixedPrice) {
		this.fixedPrice = fixedPrice;
	}
}
