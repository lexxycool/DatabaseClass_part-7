package data;

import model.Puppy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PuppyFileDAO implements PuppyDAO{
    @Override
    public List<Puppy> getPuppies() {
        List<Puppy> puppyList = new ArrayList<Puppy>();

        try {
            File file = new File("data.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String [] lineArr  = line.split("\\,");

                int id = Integer.parseInt(lineArr[0]);
                String name = lineArr[1];
                int weight = Integer.parseInt(lineArr[2]);
                String gender = lineArr[3];
                boolean trained = lineArr[4].equals("true") ? true : false;

                Puppy puppy = new Puppy(id, name, weight, gender, trained);
                puppyList.add(puppy);

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return puppyList;
    }

    @Override
    public Puppy getPuppy(int id) {
        return null;
    }

    @Override
    public void savePuppy(Puppy puppyToSave) {

    }

    @Override
    public void updatePuppy(int puppyId, int parentId) {

    }
}
