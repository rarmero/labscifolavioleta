package org.menu;

public class ModifyCommand implements Command {

    Receiver receiver;

    public ModifyCommand(Receiver r) {receiver =r;}


    @Override
    public void execute() {
        receiver.Modify();
    }
}
