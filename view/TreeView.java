package view;

import java.util.Scanner;


public class TreeView implements TreeViewInt{
    private Scanner sc;

    public TreeView(){
        sc = new Scanner(System.in);
    }

    @Override    
    public void displayMessage(String message){
        System.out.println(message);
    }

    @Override
    public String getUserInput(){
        return sc.nextLine();
    }
}
