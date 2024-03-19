package com.examples.sboot.cassandra.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("stocks")
public class Stock {
	@PrimaryKey
	private String ticker;
	private int year;
	private double value;
}
