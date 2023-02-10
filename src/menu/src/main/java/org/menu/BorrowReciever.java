package org.menu;

public class BorrowReciever implements Receiver{
    @Override
    public void Create() {
        System.out.println("call menu borrow Create action");
    }

    @Override
    public void Modify() {
        System.out.println("call menu borrow Modify action");
    }

    @Override
    public void Delete() {
        System.out.println("call menu borrow Delete action");
    }

    @Override
    public void List() {
        System.out.println("call menu borrow List action");
    }
}
