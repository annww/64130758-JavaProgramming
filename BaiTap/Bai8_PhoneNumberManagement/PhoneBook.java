package Bai8_PhoneNumberManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

class PhoneBookEntry{
    String name;
    List<String> phones;

    PhoneBookEntry(String name, String phones){
        this.name = name;
        this.phones = new ArrayList<>();
        this.phones.add(phones);
    }
}

class PhoneBook extends Phone {
    private static final String Comparator = null;
    List<PhoneBookEntry> phoneList = new ArrayList<>();

    @Override
    public void insertPhone(String name, String phone) {
        for(PhoneBookEntry entry:phoneList){
            if(entry.name.equals(name)){
                if(!entry.phones.contains(phone)){
                    entry.phones.add(phone);
                }
                return;
            }
            phoneList.add(new PhoneBookEntry(name, phone));
        }
    }

    @Override
    public void removePhone(String name) {
        phoneList.removeIf(entry -> entry.name.equals(name));
    }

    @Override
    public void updatePhone(String name, String newphone) {
        for(PhoneBookEntry entry : phoneList){
            if(entry.name.equals(name)){
                entry.phones.clear();
                entry.phones.add(newphone);
            }
        }
    }

    @Override
    public void searchPhone(String name) {
        for(PhoneBookEntry entry : phoneList){
            if(entry.name.equals(name)){
                System.out.println("Name: " + name + ", phone: " + entry.phones);
                return;
            }
            System.out.println("Name not found.");
        }
    }

    @Override
    public void sort() {
        phoneList.sort(Comparator.comparing(PhoneBookEntry::getName));
    }
}
