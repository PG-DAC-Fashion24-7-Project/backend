package com.app.models.requestDto;

public class AddToCartPayload {
	//Long userId, int productId, int unitQuantity
	private Long userId;
	private int productId;
	private int unitQuantity;
	private String sizeName;
	
	public AddToCartPayload() {
		super();
	}

	public AddToCartPayload(Long userId, int productId, int unitQuantity) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.unitQuantity = unitQuantity;
	}

	public AddToCartPayload(Long userId, int productId, int unitQuantity, String sizeName) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.unitQuantity = unitQuantity;
		this.sizeName = sizeName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUnitQuantity() {
		return unitQuantity;
	}

	public void setUnitQuantity(int unitQuantity) {
		this.unitQuantity = unitQuantity;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	
	
}
