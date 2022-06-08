// Лабораторная работа 5_Классы_Объекты Смирнов АН
public class Person {
    String fullName;        // имя
    int age;            // возраст
    Person()
    {
        fullName = "Anonymous";
        age = 18;
    }
    Person(String n, int a)
    {
        fullName = n;
        age = a;
    }
    void move(){
        System.out.printf("%s живет %d лет\n", fullName, age);
    }
    void talk(){
        System.out.printf("Такой-то  %s говорит  \n", fullName);
    }

    public static void main (String[] args) {
        Person alice = new Person();
        alice.talk();
        Person bob = new Person("Bob", 15);
        bob.move();
    }

}
