package service;

import java.io.IOException;

import newModel_1.FamilyTree;
import newModel_1.NewFamilyTree;
import newModel_1.NewPerson;
import view.TreeView;
import view.TreeViewInt;

public class CommandHandlerImpl implements CommandHandler{
    
    private FamilyTree<NewPerson> familyTree;
    private FileOperations<NewPerson> fileOps;
    private TreeViewInt view;

    public CommandHandlerImpl(FamilyTree<NewPerson> familyTree) {
        this.familyTree = familyTree;
        this.fileOps = new FileOperationsImpl<>();
        this.view = new TreeView();
    }

    public void addPerson() {
        this.view.displayMessage("Введите имя:");
        String name = this.view.getUserInput();

        this.view.displayMessage("Введите год рождения:");
        int birthYear = Integer.parseInt(this.view.getUserInput());

        NewPerson person = new NewPerson(name, birthYear);
        familyTree.addPerson(person);
        this.view.displayMessage("Человек добавлен.");
    }

    public void listPeople(FamilyTree<NewPerson> familyTree) {
        for (NewPerson person : familyTree) {
            this.view.displayMessage(person.getName() + ", родился(ась) в " +
                    person.getBirthYear());
        }
    }

    public void save(){
        try {
            fileOps.saveToFile(familyTree, "familyTree.dat");
            this.view.displayMessage("Данные сохранены");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(){
        // Загружаем генеалогическое древо из файла
        FamilyTree<NewPerson> loadedFamilyTree = null;
        try {
            loadedFamilyTree = fileOps.loadFromFile("familyTree.dat");
            this.view.displayMessage("Дерево выгруженно из файла");
        } 
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Проверяем, что древо загрузилось правильно
        if (loadedFamilyTree != null) {
            for (NewPerson person : loadedFamilyTree) {
                this.view.displayMessage("Загруженный человек: " + person.getName() + ", родился в " + person.getBirthYear());
            }
        }
        
        this.familyTree.addPeople(loadedFamilyTree);
    }

    public void delete(){
        FamilyTree<NewPerson> peopleForDelete = getPeopleByName();
        listPeople(peopleForDelete);
        this.view.displayMessage("Удалить весь список из дерева? (yes/no)");
        String option = this.view.getUserInput();

        if (option.equals("yes")){
            this.familyTree.removePeople(peopleForDelete);
        }

        else {
            this.view.displayMessage("Введите год рождения нужного человека:");
            int birthYear = Integer.parseInt(this.view.getUserInput());
            for (NewPerson person : peopleForDelete) {
                if (birthYear == person.getBirthYear()){
                    this.familyTree.removePerson(person);;
                }
            }
        }

        this.view.displayMessage("Сохранить изменения в файл? (yes/no)");
        option = this.view.getUserInput();
        if (option.equals("yes")){
            save();
        }
    }

    private FamilyTree<NewPerson> getPeopleByName(){
        FamilyTree<NewPerson> people = new NewFamilyTree<>();

        this.view.displayMessage("Введите имя:");
        String name = this.view.getUserInput();

        for (NewPerson person : familyTree) {
            if (name.equals(person.getName())){
                people.addPerson(person);
            }
        }

        return people;
    }
}
