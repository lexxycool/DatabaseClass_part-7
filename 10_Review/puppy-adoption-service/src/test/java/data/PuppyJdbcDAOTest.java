package data;

import model.Puppy;
import org.junit.*;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.util.List;

import static org.junit.Assert.*;

public class PuppyJdbcDAOTest {

    private static SingleConnectionDataSource ds;
    private PuppyDAO dao;

    @BeforeClass
    public static void setUpBeforeClass() {

        ds = new SingleConnectionDataSource();
        ds.setUrl("jdbc:postgresql://localhost:5432/puppy-adopter");
        ds.setUsername("postgres");
        ds.setPassword("postgres1");
        ds.setAutoCommit(false);
    }

    @AfterClass
    public static void tearDownAfterClass() {
        ds.destroy();
    }

    @Before
    public void setUp() throws Exception {
        dao = new PuppyJdbcDAO(ds);
    }

    @After
    public void tearDown() throws Exception {
        ds.getConnection().rollback();
    }

    @Test
    public void canRetrieveAllPuppies() {

        List<Puppy> actualListOfPuppies = dao.getPuppies();
        int actualResult = actualListOfPuppies.size();
        int expectedResult = 7;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void retrieve_1_puppy() {

        Puppy testPuppy = dao.getPuppy(3);
        String actualResult = testPuppy.getName();
        String expectedResult = "Trex";

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void add_puppy_and_retrieve() {

        Puppy testPup = new Puppy(0, "Cheems", 30, "Female", true);
        dao.savePuppy(testPup);

        List<Puppy> actualListOfPuppies = dao.getPuppies();

        boolean found = false;
        for (Puppy pup : actualListOfPuppies) {

            if (pup.getName().equals("Cheems")) {
                found = true;
            }
        }

        assertTrue(found);

    }

}