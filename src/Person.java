// ������������ ������ 5_������_������� ������� ��
public class Person {
    String fullName;        // ���
    int age;            // �������
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
        System.out.printf("%s ����� %d ���\n", fullName, age);
    }
    void talk(){
        System.out.printf("�����-��  %s �������  \n", fullName);
    }

    public static void main (String[] args) {
        Person alice = new Person();
        alice.talk();
        Person bob = new Person("Bob", 15);
        bob.move();
    }

}
