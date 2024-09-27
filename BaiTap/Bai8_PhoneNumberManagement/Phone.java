package Bai8_PhoneNumberManagement;

public abstract class Phone{
    protected String name, phone;
    
    public abstract void insertPhone(String name, String phone);
    public abstract void removePhone(String name);
    public abstract void updatePhone(String name, String newphone);
    public abstract void searchPhone(String name);
    public abstract void sort();
}