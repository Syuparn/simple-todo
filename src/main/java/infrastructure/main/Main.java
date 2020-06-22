package infrastructure.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String jsonFileName = "todo.json";
        MainHandler handler = new MainHandler(jsonFileName);
        
        // get command from stdin
        printIntro();
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        switch (command) {
            case "create":
                System.out.println("Input to-do item:");
                create(scanner.nextLine(), handler);
                break;
            case "delete":
                System.out.println("Input to-do item:");
                delete(scanner.nextLine(), handler);
                break;
            case "find":
                System.out.println("Input tag:");
                find(scanner.nextLine(), handler);
                break;
            case "list":
                list(handler);
                break;
            default:
                System.out.println("invalid command");
                break;
        }
    }

    private static void create(String bodyStr, MainHandler handler) {
        handler.create(bodyStr);
    }

    private static void delete(String bodyStr, MainHandler handler) {
        handler.delete(bodyStr);
    }

    private static void find(String tagStr, MainHandler handler) {
        handler.find(tagStr);
    }

    private static void list(MainHandler handler) {
        handler.list();
    }

    private static void printIntro() {
        System.out.println("commands: create | find | list | delete");
    }
}
