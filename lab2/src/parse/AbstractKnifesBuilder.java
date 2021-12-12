package parse;

import main.Knife;
import java.util.ArrayList;

public abstract class AbstractKnifesBuilder {
    protected ArrayList<Knife> knifes;
    public AbstractKnifesBuilder() {
        knifes = new ArrayList<Knife>();
    }
    public AbstractKnifesBuilder(ArrayList<Knife> students) {
        this.knifes = students;
    }
    public ArrayList<Knife> getKnifes() {
        return knifes;
    }
    public abstract void buildListKnifes(String filename);
}
