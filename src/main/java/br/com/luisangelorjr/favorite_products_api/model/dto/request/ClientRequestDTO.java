package br.com.luisangelorjr.favorite_products_api.model.dto.request;

import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Valid
public class ClientRequestDTO {

	@Size(min = 1, max = 200, message = "'name' must be between 1 and 200 characters")
	@NotBlank(message = "'name' is required")
	private String name;

	@Size(min = 3, max = 200, message = "'email' must be between 3 and 200 characters")
	@Email(message = "'email' need a standard recognized")
	@NotBlank(message = "'email' is required")
	private String email;

	public ClientRequestDTO(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public ClientRequestDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientRequestDTO other = (ClientRequestDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "ClientRequestDTO [name=" + name + ", email=" + email + "]";
	}

}
