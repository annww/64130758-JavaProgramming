package Bai7_Interface;

public class MainApp {
    public static void main(String[] args) {
        Cat cat = new Cat("Tam the", false);
        Dog dog = new Dog("Chihuahua",true);
        System.out.println(cat.toString());
        cat.Sound();
        System.out.println(dog.toString());
        dog.Sound();

        IAnimal c1 = new Cat("Tam the",false);
        IAnimal c2 = new Dog("Chihuahua",true);
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }
}
