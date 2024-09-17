package Bai7_Interface;

public class Cat implements IAnimal {
    private String category;
    private boolean gender;

    public Cat(String category, boolean gender) {
        this.category = category;
        this.gender = gender;
    }
    @Override
    public void Sound(){
        System.out.println("Meo meo ");
    }
    @Override
    public String toString() {
        return "Cat [category=" + category + ", gender=" + gender + "]";
    }
    
}
