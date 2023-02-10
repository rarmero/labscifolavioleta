package org.menu.utils.command;

public class Invoker {

    Command command;

    public Invoker(){

    }

    public void setCommand(Command c)
    {
        command = c;
    }
    public void run() {
        command.execute();
    }

}
