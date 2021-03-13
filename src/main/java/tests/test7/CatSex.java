package tests.test7;

public enum CatSex {
    MALE("Кот"),
    FEMALE("Кошка");

    private final String sex;

    CatSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public String getSatietyWord(boolean satiety) {
        if (this == MALE) {
            return satiety ? "сытый" : "голодный";
        } else {
            return satiety ? "сытая" : "голодная";
        }
    }
}
