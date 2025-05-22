package br.com.luisangelorjr.favorite_products_api.client.rest.fakestoreapi;

import java.util.Objects;

public class FakeStoreRatingResponseDTO {

	private Double rate;
	private Integer count;

	public FakeStoreRatingResponseDTO() {
		super();
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		return Objects.hash(count, rate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FakeStoreRatingResponseDTO other = (FakeStoreRatingResponseDTO) obj;
		return Objects.equals(count, other.count) && Objects.equals(rate, other.rate);
	}

	@Override
	public String toString() {
		return "FakeStoreRatingResponseDTO [rate=" + rate + ", count=" + count + "]";
	}

}
