package org.menu.utils.command;

public class CreateCommand implements Command{
    Receiver receiver;

    public CreateCommand(Receiver r){
        receiver = r;
    }

    @Override
    public void execute(){

        receiver.Create();
    }
}
