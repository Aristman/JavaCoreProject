package tests.test10;

import java.util.*;


public class PhoneBook {
    private final HashMap<String, ArrayList<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    // Метод добавления записи в телефонную книгу. Ключ для записи - фамилия.
    // Одинаковые телефоны для одного ключа игнорируются.
    public void add(String name, String phone) {
        HashSet<String> phones = new HashSet<>(get(name));
        phones.add(phone);
        phoneBook.put(name, new ArrayList<>(phones));
    }

    // Метод поиска телефона по фамилии. Возвращает список найденных телефонов.
    // Если нет такой фамилии в справочнике то возвращается пустой список
    public ArrayList<String> get(String findName) {
        ArrayList<String> phoneList = phoneBook.get(findName);
        return Objects.requireNonNullElseGet(phoneList, ArrayList::new);
    }
}
