package service;

import newModel_1.FamilyTree;
import newModel_1.NewPerson;

public interface CommandHandler {
    void addPerson();
    void save();
    void listPeople(FamilyTree<NewPerson> familyTree);
    void load();
    void delete();
}
