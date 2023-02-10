package org.menu;

public class UserReciever implements Receiver{

    @Override
    public void Create() {System.out.println("call menu user Create action");}

    @Override
    public void Modify() {
        System.out.println("call menu user Modify action");
    }

    @Override
    public void Delete() {
        System.out.println("call menu user Delete action");
    }

    @Override
    public void List() {
        System.out.println("call menu user List action");
    }
}
