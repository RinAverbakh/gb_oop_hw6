package service;

import newModel_1.FamilyTree;
import newModel_1.NewPerson;
import view.TreeView;
import view.TreeViewInt;

public class CommandManager {
    private CommandHandler ch;
    private TreeViewInt view;
    private FamilyTree<NewPerson> familyTree;

    public CommandManager(FamilyTree<NewPerson> familyTree) {
        this.ch = new CommandHandlerImpl(familyTree);
        this.view = new TreeView();
        this.familyTree = familyTree;
        
    }

    public void start() {
        while (true) {
            
            this.view.displayMessage("Введите номер команды:\n" + 
                "1. Добавить человека в древо\n" + 
                "2. Показать список всех людей\n" + 
                "3. Отсортировать список по имени\n" + 
                "4. Отсортировать список по году рождения\n" + 
                "5. Сохранить в файл\n" + 
                "6. Загрузить из файла\n" +
                "7. Удалить человека\n" +
                "0. Выйти из программы");
            int command = Integer.parseInt(this.view.getUserInput());

            switch (command) {

                case 1:
                    ch.addPerson();
                    break;

                case 2:
                    ch.listPeople(this.familyTree);
                    break;

                case 3:
                    familyTree.sortByName();
                    ch.listPeople(this.familyTree);
                    break;

                case 4:
                    familyTree.sortByBirthYear();
                    ch.listPeople(this.familyTree);
                    break;

                case 5:
                    ch.save();
                    break;

                case 6:
                    ch.load();
                    break;

                case 7:
                    ch.delete();
                    break;

                case 0:
                    return;

                default:
                this.view.displayMessage("Неизвестная команда");
            }
        }
    }
}
