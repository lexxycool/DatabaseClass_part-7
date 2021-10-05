package data;

import model.Puppy;

import java.util.List;

public interface PuppyDAO {

    public List<Puppy> getPuppies();
    public Puppy getPuppy(int id);
    public void savePuppy(Puppy puppyToSave);
    public void updatePuppy(int puppyId, int parentId);
}
