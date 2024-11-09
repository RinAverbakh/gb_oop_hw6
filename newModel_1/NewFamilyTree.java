package newModel_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NewFamilyTree<P extends FamilyTreesObject> implements FamilyTree<P>{

    private List<P> family;

    public NewFamilyTree(){
        this.family = new ArrayList<>();
    }

    @Override
    public void addPerson(P person) {
        this.family.add(person);
    }

    @Override
    public void addPeople(FamilyTree<P> newFamilyTree) {
        for (P person : newFamilyTree) {
            this.family.add(person);
        }
    }

    @Override
    public List<P> getPeople() {
        return family;
    }

    @Override
    public Iterator<P> iterator() {
        return family.iterator();
    }

    @Override
    public void sortByName() {
        Collections.sort(this.family, (p1, p2) -> p1.toString().compareTo(p2.toString()));
    }

    @Override
    public void sortByBirthYear() {
        if(family.get(0)instanceof FamilyTreesObject){
            Collections.sort(family,(p1,p2) -> Integer.compare(((P)p1).getBirthYear(),((P) p2).getBirthYear()));
        }
    }


    @Override
    public void removePerson(P person) {
        this.family.remove(person);
    }

    @Override
    public void removePeople(FamilyTree<P> people) {
        for (P person : people) {
            this.family.remove(person);
        }
    }

    @Override
    public void setMother(P mother, P child) {
        child.setMother(mother);
        mother.addChild(child);
    }

    @Override
    public void setFather(P father, P child) {
        child.setFather(father);
        father.addChild(child);
    }

    @Override
    public List<P> getPeopleByName(String name) {
        List<P> result = new ArrayList<>();
        for (P person : family) {
            if (name.equals(person.getName())){
                result.add(person);
            }
        }
        return result;
    }
}
