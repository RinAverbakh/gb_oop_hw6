package main;

import newModel_1.NewPerson;
import newModel_1.FamilyTree;
import newModel_1.NewFamilyTree;

import service.CommandManager;

public class Main{
    public static void main(String[] args) {

        FamilyTree<NewPerson> familyTree = new NewFamilyTree<>();
        CommandManager cm = new CommandManager(familyTree);
        cm.start();

    }
}
