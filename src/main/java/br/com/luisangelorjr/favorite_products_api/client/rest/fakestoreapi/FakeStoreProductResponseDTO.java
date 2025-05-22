package br.com.luisangelorjr.favorite_products_api.client.rest.fakestoreapi;

import java.math.BigDecimal;
import java.util.Objects;

public class FakeStoreProductResponseDTO {

	private Integer id;
	private String title;
	private BigDecimal price;
	private String description;
	private String category;
	private String image;
	private FakeStoreRatingResponseDTO rating;

	public FakeStoreProductResponseDTO() {
		super();
	}

	public FakeStoreProductResponseDTO(Integer id, String title, BigDecimal price, String description, String category,
			String image, FakeStoreRatingResponseDTO rating) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.description = description;
		this.category = category;
		this.image = image;
		this.rating = rating;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public FakeStoreRatingResponseDTO getRating() {
		return rating;
	}

	public void setRating(FakeStoreRatingResponseDTO rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, description, id, image, price, rating, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FakeStoreProductResponseDTO other = (FakeStoreProductResponseDTO) obj;
		return Objects.equals(category, other.category) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(image, other.image)
				&& Objects.equals(price, other.price) && Objects.equals(rating, other.rating)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "FakeStoreProductResponseDTO [id=" + id + ", title=" + title + ", price=" + price + ", description="
				+ description + ", category=" + category + ", image=" + image + ", rating=" + rating + "]";
	}

}
