package com.stockservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_stock")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
	
	@Id
	private String itemname;
	private Long stock;

}
