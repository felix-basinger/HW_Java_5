import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homework5 {
    public static void book(HashMap<String, List<String>> phoneBook, String key, String value) {
        phoneBook.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        book(phoneBook, "Самойлов", "89187771112");
        book(phoneBook, "Васильев", "89187771112");
        book(phoneBook, "Самойлов", "89187723413");
        book(phoneBook, "Васильев", "89187771564");
        book(phoneBook, "Петров", "89180000001");
        book(phoneBook, "Сидоров", "89180000002");
        book(phoneBook, "Чернышевский", "89180000003");

        phoneBook.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(((o1, o2) -> o2.size() - o1.size())))
                .forEach(System.out::println);
    }
}
