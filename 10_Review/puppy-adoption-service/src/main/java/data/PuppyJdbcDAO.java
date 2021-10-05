package data;

import model.Puppy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class PuppyJdbcDAO implements PuppyDAO{

    private JdbcTemplate template;

    public PuppyJdbcDAO(DataSource ds) {

        this.template = new JdbcTemplate(ds);
    }

    @Override
    public List<Puppy> getPuppies() {

        String sql = "SELECT id, name, weight, gender, paper_trained FROM puppies";
        List<Puppy> puppyList = new ArrayList<>();

        SqlRowSet results = template.queryForRowSet(sql);

        while (results.next()) {

            int id = results.getInt("id");
            String name = results.getString("name");
            int weight = results.getInt("weight");
            String gender = results.getString("gender");
            boolean paperTrained = results.getBoolean("paper_trained");

            Puppy puppy = new Puppy(id, name, weight, gender, paperTrained);
            puppyList.add(puppy);
        }

        return puppyList;
    }

    @Override
    public Puppy getPuppy(int id) {

        String sql = "SELECT id, name, weight, gender, paper_trained FROM puppies WHERE id = ?";
        SqlRowSet results = template.queryForRowSet(sql, id);

        Puppy puppy = null;

        if (results.next()) {

            int id2 = results.getInt("id");
            String name = results.getString("name");
            int weight = results.getInt("weight");
            String gender = results.getString("gender");
            boolean paperTrained = results.getBoolean("paper_trained");

            puppy = new Puppy(id2, name, weight, gender, paperTrained);
        }

        return puppy;
    }

    @Override
    public void savePuppy(Puppy puppyToSave) {

        String name = puppyToSave.getName();
        int weight = puppyToSave.getWeight();
        String gender = puppyToSave.getGender();
        boolean isPaperTrained = puppyToSave.isPaperTrained();

        String sql = "INSERT INTO puppies(name, weight, gender, paper_trained) VALUES(?, ?, ?, ?)";
        template.update(sql, name, weight, gender, isPaperTrained);

    }

    @Override
    public void updatePuppy(int puppyId, int parentId) {

    }
}
