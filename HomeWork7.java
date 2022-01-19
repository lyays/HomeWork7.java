/**
 * GU_QA_1524 (08.06.2021)
 * Java 1. Homework #7
 *
 * @author Nurgalina Lyaysan
 * @version 13.01.2022 - 14.01.2021
 *
 */

public class HomeWork7 {
    public static void main(String[]args) {
        Cat[]cats = {
            new Cat("Murka", 15),
            new Cat("Bantik", 20),
            new Cat("Tumanchik", 25)
        };

        Plate plate = new Plate(50, 25);
        System.out.println(plate);

        //кормление кошек в первый раз
        for (Cat cat: cats) {
            cat.eat(plate);
            System.out.println(cat);
        }

        //добавление еды в тарелку
        System.out.println(plate);
        plate.add(40);
        System.out.println(plate);

        // (plate.setFood(plate.getFood() - cat.getAppetite()); //кот ест)
        // (plate.decreaseFood(cat.getAppetite());)
        //        cat.eat(plate);
        //        System.out.println(plate);


        //кормление кошек во второй раз
        for (Cat cat: cats) {
            cat.setFullness(false); //make the cat hungry
            cat.eat(plate);
            System.out.println(cat);
        }
        System.out.println(plate);
    }
}

class Cat {
    protected String name;
    protected int appetite; //может поесть за один раз
    protected boolean fullness; //статус сытости

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        fullness = false;
    }

    void setFullness(boolean status) {
        fullness = status;
    }

    void eat(Plate plate) { //передаем в качестве параметра объект
        if (!fullness) {
            fullness = plate.decreaseFood(appetite);
        }
    }
    //    int getAppetite() {
    //        return appetite;
    //    }

     @ Override
    public String toString() {
        return "{name: " + name + ", appetite: " + appetite + ", fullness: " + fullness + "}";
    }
}

class Plate {
    protected int food;
    protected int volume;

    Plate(int food, int volume) {
        this.food = food;
        this.volume = volume;
    }

    //    int getFood() {
    //        return food;
    //    }
    //
    //    void setFood(int food) {
    //        this.food = food;
    //    }

    boolean decreaseFood(int portion) {
        if (food < portion) {
            return false;
        }
        food -= portion;
        return true;
        //this.food -= food;          //отнимаем и возвращяем   Уменьшить объем тарелки
    }

    void add(int food) {
        if (this.food + food <= volume) {
            this.food += food;
        }
    }

     @ Override
    public String toString() {
        return "Plate: " + food;
    }

}
