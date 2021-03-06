/*
 * Класс "Сотрудник"
 * Конструктор заполняет все поля.
 * Сеттеры возвращают true если запись нового значения производится удачно
 * В случае неудачи (не проходит проверку на правильность вводных данных) возвращается false
 */

package tests.test5;

public class Worker {
    private static final int MIN_AGE = 18; // Минимальный возраст приема на работу
    private static final int MAX_AGE = 90; // Максимальный возраст сотрудника. Далее - заслуженный отдых.
    private static final int MIN_PAY = 12130; // Минимальный размер оплаты труда

    private String name;
    private String post;
    private String eMail;
    private String telephone;
    private int pay;
    private int age;

    public Worker(String name, String post, String eMail, String telephone, int pay, int age) {
        this.name = name;
        this.post = post;
        this.eMail = eMail;
        this.telephone = telephone;
        this.pay = pay;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public boolean setAge(int age) {
        if (age >= MIN_AGE && age <= MAX_AGE) {
            this.age = age;
            return true;
        }
        return false;
    }

    public int getPay() {
        return pay;
    }

    public boolean setPay(int pay) {
        if (pay >= MIN_PAY) {
            this.pay = pay;
            return true;
        }
        return false;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String geteMail() {
        return eMail;
    }

    public boolean seteMail(String eMail) {
        if (eMail.contains("@")) {
            this.eMail = eMail;
            return true;
        }
        return false;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.printf("Имя: %s\nДолжность: %s\ne-mail: %s\nТелефон: %s\n" +
                        "Зарплата: %d\nВозраст: %d\n",
                this.name,
                this.post,
                this.eMail,
                this.telephone,
                this.pay,
                this.age);
    }
}
