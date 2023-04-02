package com.scatter.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coordinates")
public class Cordinate {

	public Cordinate() {}
	
	  public Cordinate(Double xDirection, Double yDirection) {
		  this.xDirection =xDirection; 
		  this.yDirection = yDirection; 
		  }
	
	/*
	 * public Cordinate(double parseDouble, double parseDouble2) { // TODO
	 * Auto-generated constructor stub }
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "x_direction")
	@NonNull
	private Double xDirection;

	@Column(name = "ÿ_direction")
	@NonNull
	private Double yDirection;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getxDirection() {
		return xDirection;
	}

	public void setxDirection(Double xDirection) {
		this.xDirection = xDirection;
	}

	public Double getyDirection() {
		return yDirection;
	}

	public void setyDirection(Double yDirection) {
		this.yDirection = yDirection;
	}

}
