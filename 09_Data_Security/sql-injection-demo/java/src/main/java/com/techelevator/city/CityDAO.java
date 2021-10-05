package com.techelevator.city;

import java.util.List;

public interface CityDAO {

	public List<City> findCityByCountryCode(String countryCode);

}
