// Лабораторная работа_ООП Смирнов АН
public class Biblio {

    public static void main(String[] args) {
        Reader reader1 = new Reader("Вася", 10);
        reader1.takeBook(17);
        reader1.returnBook(7);

        Libra libra1 = new Libra("Марья Петровна", 60);
        libra1.orderBook(200);

        Provider prov1 = new Provider("Возген", 60);
        prov1.deliveryBook(5);

        Admin admin1 = new Admin("Возген", 60);
        admin1.findBook("Java для чайников");
        admin1.getBook("Чайники для Java");
        admin1.notifyDelay(reader1);
    }

    public interface roleReader {
        void takeBook(int book);
        void returnBook(int book);
    }
    interface roleLibra {
        void orderBook(int book);
    }
    interface roleProvider {
        void deliveryBook(int book);
    }
    interface roleAdmin {
        void findBook(String book);
        void getBook(String book);
        void notifyDelay(Reader reader);
    }

    public static class User {
        private final String name;
        private final int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static class Reader extends User implements roleReader {
        private int numOfBooks = 0;

        public Reader(String name, int age) {
            super(name, age);
        }

        public int getNumOfBooks() {
            return numOfBooks;
        }

        public void takeBook(int book) {
            numOfBooks += book;
            System.out.format("%s взял %s книг. Всего он должен вернуть %d книг\n", super.getName(), book, getNumOfBooks());
        }

        public void returnBook(int book) {
            numOfBooks -= book;
            System.out.format("%s вернул %s книг. Осталось  вернуть %d книг\n", super.getName(), book, getNumOfBooks());
        }
    }

    public static class Libra extends User implements roleLibra {

        public Libra(String name, int age) {
            super(name, age);
        }

        public void orderBook(int book) {
            System.out.format("Библиотекарь %s заказал(а) %s книг.\n", super.getName(), book);
        }
    }

    public static class Provider extends User implements roleProvider {

        public Provider(String name, int age) {
            super(name, age);
        }

        public void deliveryBook(int book) {
            System.out.format("Поставщик %s доставил в библиотеку %s книг.\n", super.getName(), book);
        }
    }

    public static class Admin extends User implements roleAdmin {

        public Admin(String name, int age) {
            super(name, age);
        }

        public void findBook(String book) {
            System.out.format("Администратор %s пошел искать книгу %s \n", super.getName(), book);
        }
        public void getBook(String book) {
            System.out.format("Администратор %s выдал книгу %s \n", super.getName(), book);
        }

        public void notifyDelay(Reader reader) {
            System.out.printf("Читатель %s задолжал %s книг \n", reader.getName(), reader.numOfBooks);
        }
    }
}
