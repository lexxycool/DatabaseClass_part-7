package com.techelevator.city;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO {

	@Override
	public List<City> findCityByCountryCode(String state) {
		List<City> cities = new ArrayList<>();
		System.out.println("code search: " + state);

		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:postgresql://localhost:5432/UnitedStates");
		ds.setUsername("postgres");
		ds.setPassword("postgres1");

		try {
			Connection connection = ds.getConnection();
			String sql = "SELECT city_id, city_name, population, area FROM city "
					+ "WHERE state_abbreviation = '" + state + "'";

			ResultSet rs = connection.createStatement().executeQuery(sql);
			while(rs.next()){
				long id = rs.getLong("city_id");
				String name = rs.getString("city_name");
				long population = Long.parseLong(rs.getString("population"));
				double  area = Double.parseDouble(rs.getString("area"));


				City city = new City();
				city.setId(id);
				city.setName(name);
				city.setPopulation(population);
				city.setArea(area);

				cities.add(city);

			}

		}catch(SQLException e){
			System.out.println(e);
		}

		return cities;
	}

}
