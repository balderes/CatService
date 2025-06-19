package com.balderes.cats.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Table(name = "cats")
@Entity
public class Cat {

	public Cat(String name, Integer age, Double weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	public Cat() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(unique = true)
	private String name;

	private Integer age;

	private Double weight;
}

