package org.menu;

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
