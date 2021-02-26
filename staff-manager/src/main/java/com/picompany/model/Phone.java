package com.picompany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
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
@Table(name = "phone", uniqueConstraints = { @UniqueConstraint(columnNames = "number") })
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "The DDD cannot be empty or null")
	@Column(length = 2, nullable = false)
	private int ddd;
	
	@Size(min = 8, max = 9, message = "The phone number length must be between 8 and 9 numbers")
	@NotEmpty(message = "The phone number cannot empty or null")
	@Pattern(regexp = "^[0-9]+$", message = "The phone number has invalid characters")
	@Column(nullable = false, unique = true, length = 9)
	private String number;
	
	@NotEmpty(message = "The phone type cannot empty or null")
	@Column(nullable = false, length = 20)
	private String type;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="user_id", nullable=false)
	private User user;
}
