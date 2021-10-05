package com.techelevator.view;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.util.List;
import java.util.Scanner;

public class CLI {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("State?");
        String state = scanner.nextLine();

        CityDAO dao = new JDBCCityDAO();
        List<City> results = dao.findCityByCountryCode(state);
        nicePrint(results);

    }

    public static void nicePrint(List<City> cities) {

        for (City city : cities) {
            System.out.println(city.getName() + " " + city.getPopulation());
        }
    }
}
