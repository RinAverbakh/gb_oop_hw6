package newModel_1;

import java.io.Serializable;
import java.util.List;

public interface FamilyTree<P extends FamilyTreesObject> extends Serializable, Iterable<P>{
    void addPerson(P person);
    void addPeople(FamilyTree<P> newFamilyTree);
    List<P> getPeople();
    void sortByName();
    void sortByBirthYear();
    void removePerson(P person);
    void removePeople(FamilyTree<P> people);
    void setMother(P mother, P child);
    void setFather(P father, P child);
    List<P> getPeopleByName(String name);
}
