package newModel_1;

import java.io.Serializable;
import java.util.List;

public interface FamilyTreesObject extends Serializable{

    String getName();
    int getBirthYear();
    void setMother(FamilyTreesObject mother);
    void setFather(FamilyTreesObject father);
    void addChild(FamilyTreesObject child);
    List<FamilyTreesObject> getChildren();
    FamilyTreesObject getMother();
    FamilyTreesObject getFather();

}
