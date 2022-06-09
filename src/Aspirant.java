//Лабораторная работа_Наследование
public class Aspirant extends Student{
    String ScientificWork;

    Aspirant(String fn, String ln, String g, double avr, String sf)
    {
        super(fn, ln, g, avr);
        ScientificWork = sf;
    }
    @Override
    int getScholarship() {
        if (this.averageMark == 5) {
            return 200;
        }
        else {
            return 180;
        }
    }
}
