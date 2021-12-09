package parse;

import com.classes.Knife;
import com.classes.Visual;
import java.util.Set;
import java.util.HashSet;

public abstract class AbstractKnifesBuilder {
    protected Set<Knife> knifes;
    public AbstractKnifesBuilder() {
        knifes = new HashSet<Knife>();
    }
    public AbstractKnifesBuilder(Set<Knife> students) {
        this.knifes = students;
    }
    public Set<Knife> getKnifes() {
        return knifes;
    }
    public abstract void buildSetKnifes(String filename);
}
