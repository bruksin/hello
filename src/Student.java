//������������ ������_������������
public class Student {
    String firstName, lastName, group;
    double averageMark;

    Student(String fn, String ln, String g, double avr)
    {
        firstName = fn;
        lastName = ln;
        group = g;
        averageMark = avr;
    }

    int getScholarship() {
        if (this.averageMark == 5) {
            return 100;
        }
        else {
            return 80;
        }
    }



    public static void main (String[] args) {
        Student[] stud = new Student[5];
        stud[0] = new Student("����", "���������", "A", 5.0);
        stud[1] = new Student("����", "������", "A", 5.0);
        stud[2] = new Student("Alice", "Smith", "A", 3.0);
        stud[3] = new Aspirant("Bob", "Burbon", "B", 5.0, "������� ����");
        stud[4] = new Aspirant("Dick", "Big", "D", 4.0, "�����������");

        for (int i=0;i<5;i++) {
            System.out.printf("��������� %s %s ���������� %d ������  \n", stud[i].firstName, stud[i].firstName, stud[i].getScholarship());
        }
    }
}
