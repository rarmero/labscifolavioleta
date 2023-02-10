package org.menu.utils.command;

public class DeleteCommand implements Command{

    Receiver receiver;

    public  DeleteCommand(Receiver r){
        receiver = r;
    }


    @Override
    public void execute() {
        receiver.Delete();
    }
}
