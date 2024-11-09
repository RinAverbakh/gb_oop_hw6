package service;

import newModel_1.FamilyTree;
import newModel_1.FamilyTreesObject;

import java.io.*;

public interface FileOperations<P extends FamilyTreesObject> {
    void saveToFile(FamilyTree<P> familyTree, String fileName) throws IOException;

    FamilyTree<P> loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}
