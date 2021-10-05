package com.techelevator.city;

public class City {
	private Long id;
	private String name;
	private double area;
	private long population;

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


	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "{" +
				"id=" + id +
				", name='" + name + '\'' +
				", area=" + area +
				", population=" + population +
				'}';
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
}
