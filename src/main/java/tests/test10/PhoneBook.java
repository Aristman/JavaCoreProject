package tests.test10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneBook {
    static class PhoneRecord {
        private final String name;
        private final String phoneNumber;

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public PhoneRecord(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }

    private final ArrayList<PhoneRecord> records = new ArrayList<>();

    public PhoneBook() {
    }

    public void add(String name, String phone) {
        records.add(new PhoneRecord(name, phone));
    }

    // Метод поиска телефона по фамилии. Возвращает список найденных телефонов.
    // Если нет такой фамилии в справочнике то возвращается пустой список
    public List<String> get(String findName) {
        return records.stream()
                .filter(phoneRecord -> phoneRecord.getName().equals(findName))
                .map(PhoneRecord::getPhoneNumber)
                .collect(Collectors.toList());
    }
}
