package org.menu.view;

import org.menu.utils.command.*;

import java.util.Scanner;

public class Menu {
    public void init()
    {
        Scanner scanner = new Scanner(System.in);
        String optionSelected;

        Invoker invoker = new Invoker();
        UserReciever userReciever  = new UserReciever();
        BorrowReciever borrowReciever = new BorrowReciever();
        //commands

        CreateCommand createCommandUser = new CreateCommand(userReciever);
        ModifyCommand modifyCommandUser = new ModifyCommand(userReciever);
        DeleteCommand deleteCommandUser = new DeleteCommand(userReciever);
        ListCommand listCommandUser = new ListCommand(userReciever);

        CreateCommand createCommandBorrow = new CreateCommand(borrowReciever);
        ModifyCommand modifyCommandBorrow = new ModifyCommand(borrowReciever);
        DeleteCommand deleteCommandBorrow = new DeleteCommand(borrowReciever);
        ListCommand listCommandBorrow = new ListCommand(borrowReciever);

        String menuMain= """
        Commands:\\nS - stops the program\\nU - User\\n" +
               "BW - Borrow\\nBk - Books\\n
        """;

        String menu = """
        Commands:\\nL - lists\\nstop - stops the program\\nC - Create\\n" +
        "M - Modify\\nD - Delete\\n
        """;

        System.out.println(menuMain);

        while(true) {

            System.out.println("Enter command:");
            optionSelected = scanner.nextLine();

        if (optionSelected.equals("stop")) {
           break;
        }

        if (optionSelected.equals("B") ) {

            System.out.println(menu);

            while(true) {

                System.out.println("Enter command:");
                optionSelected = scanner.nextLine();

                if (optionSelected.equals("stop")) {
                    optionSelected="";
                    break;
                }

                if (optionSelected.equals("C")) {
                    invoker.setCommand((createCommandBorrow));
                    invoker.run();
                }
                if (optionSelected.equals("L")) {
                    invoker.setCommand((listCommandBorrow));
                    invoker.run();
                }
                if (optionSelected.equals("M")) {
                    invoker.setCommand((modifyCommandBorrow));
                    invoker.run();
                }
                if (optionSelected.equals("D")) {
                    invoker.setCommand(deleteCommandBorrow);
                    invoker.run();
                }
            }

        }

        if (optionSelected.equals("U") ) {

            System.out.println(menu);


            while(true) {

                System.out.println("Enter command:");
                optionSelected = scanner.nextLine();

                if (optionSelected.equals("stop")) {
                    optionSelected="";
                    break;
                }

                if (optionSelected.equals("C")) {
                    invoker.setCommand((createCommandUser));
                    invoker.run();
                }
                if (optionSelected.equals("L")) {
                    invoker.setCommand((listCommandUser));
                    invoker.run();
                }
                if (optionSelected.equals("M")) {
                    invoker.setCommand((modifyCommandUser));
                    invoker.run();
                }
                if (optionSelected.equals("D")) {
                    invoker.setCommand(deleteCommandUser);
                    invoker.run();
                }
            }

        }

        if (optionSelected.isBlank())
        {
            System.out.println(menuMain);
        }

        }
    }
}
