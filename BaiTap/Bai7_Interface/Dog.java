package Bai7_Interface;

public class Dog implements IAnimal{
    public String name;
    public boolean gender;

    
    public Dog(String name, boolean gender) {
        this.name = name;
        this.gender = gender;
    }
    
    @Override
    public void Sound(){
        System.out.println("Gau gau");
    }
    @Override
    public String toString() {
        return "Dog [name=" + name + ", gender=" + gender + "]";
    }
    
}
