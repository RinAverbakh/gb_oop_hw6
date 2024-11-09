package newModel_1;

import java.util.ArrayList;
import java.util.List;

public class NewPerson implements FamilyTreesObject{
    private String name;
    private int birthYear;
    private FamilyTreesObject mother;
    private FamilyTreesObject father;
    private List<FamilyTreesObject> children;

    public NewPerson(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public void setMother(FamilyTreesObject mother) {
        this.mother = mother;
    }

    @Override
    public void setFather(FamilyTreesObject father) {
        this.father = father;
    }

    @Override
    public void addChild(FamilyTreesObject child) {
        this.children.add(child);
    }

    @Override
    public List<FamilyTreesObject> getChildren() {
        return children;
    }

    @Override
    public FamilyTreesObject getMother() {
        return mother;
    }

    @Override
    public FamilyTreesObject getFather() {
        return father;
    }
}
