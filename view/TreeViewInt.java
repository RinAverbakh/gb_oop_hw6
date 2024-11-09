package view;


public interface TreeViewInt extends TreeDisplay, TreeInput{

    void displayMessage(String message);
    String getUserInput();

    // void setPresenter(CommandManager presenter); //не используется
}
