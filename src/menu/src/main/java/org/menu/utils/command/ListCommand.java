package org.menu.utils.command;

public class ListCommand implements Command{
    Receiver receiver;

    public ListCommand(Receiver r){
        receiver = r;
    }

    @Override
    public void execute() {
        receiver.List();
    }
}
