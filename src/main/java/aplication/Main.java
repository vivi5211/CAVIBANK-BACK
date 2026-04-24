package aplication;

import aplication.configuration.Config;
import aplication.userinterface.MenuApp;

public class Main {
    public static void main(String[] args) {
        MenuApp menuApp = Config.createMenuApp();
        menuApp.showMainMenu();
    }
}