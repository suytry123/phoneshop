
package com.java.school.phoneshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "models")
public class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "model_id")
	private Long id;

	@Column(name = "model_name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
}
