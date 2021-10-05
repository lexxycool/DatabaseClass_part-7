package view;

import data.PuppyDAO;
import data.PuppyFileDAO;
import data.PuppyJdbcDAO;
import model.Puppy;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;

public class PuppyCLI {

    public static void main(String[] args) {

        System.out.println("Hello World");

        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:postgresql://localhost:5432/puppy-adopter");
        ds.setUsername("postgres");
        ds.setPassword("postgres1");

        PuppyDAO dao = new PuppyFileDAO();

        List<Puppy> puppies = dao.getPuppies();

        for (Puppy puppy : puppies) {
            System.out.println(puppy.getName() + " " + puppy.getWeight());
        }

        Puppy trexPuppy = dao.getPuppy(3);
        System.out.println(trexPuppy.getName());

        Puppy testPup = new Puppy(10, "Doge II", 53, "male", false);
        dao.savePuppy(testPup);


    }
}
