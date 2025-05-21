package br.com.luisangelorjr.favorite_products_api.model.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 1, max = 200, message = "'name' must be between 1 and 200 characters")
	@NotBlank(message = "'name' is required")
	private String name;

	@Size(min = 3, max = 200, message = "'email' must be between 3 and 200 characters")
	@Email(message = "'email' need a standard recognized")
	@NotBlank(message = "'email' is required")
	@Column(unique = true, nullable = false)
	private String email;

	public Client() {
		super();
	}

	public Client(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return Objects.hash(email, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
