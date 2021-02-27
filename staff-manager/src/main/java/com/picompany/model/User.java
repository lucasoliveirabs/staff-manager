package com.picompany.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
public class User implements Serializable {
	private static final long serialVersionUID = 4272123141865013220L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 6, max = 100, message = "The name length must be between 6 and 60 characters")
	@NotEmpty(message = "The name cannot be empty or null")
	@Column(length = 60, nullable = false)
	private String name;

	@Size(min = 6, max = 60, message = "The e-mail address length must be between 5 and 50 characters")
	@NotEmpty(message = "The e-mail address cannot be empty or null")
	@Email(message = "The e-mail address must be valid")
	@Column(length = 50, nullable = false)
	private String email;

	@Size(min = 8, max = 30, message = "The password length must be between 8 and 30 characters")
	@NotEmpty(message = "The password cannot be empty or null")
	@Column(length = 30, nullable = false)
	private String password;

	@NotNull(message = "The category cannot be null")
	@Column(nullable = false)
	private Boolean category;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Phone> phones;
}
