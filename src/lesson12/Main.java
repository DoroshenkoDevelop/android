package lesson12;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        findWord();
        searchElement();
        String[] wordsAnagram = {"listen", "silent", "enlist", "java", "avaj", "world"};
        Map<String, List<String>> anagramGroups = groupWordAnagram(wordsAnagram);

        for (List<String> group : anagramGroups.values()) {
            System.out.println(group);
        }
        repeatingNumber();
    }
    /*Задача 1: Подсчет количества слов в тексте
       Подсчитать количество вхождений каждого слова в тексте.*/

    public static void findWord() {
        String str = "Hello World";
        String[] arr = str.toLowerCase().split(" ");
        Map<String, Integer> counter = new HashMap<>();
        for (String element : arr) {
            int value = counter.getOrDefault(element, 0) + 1;
            counter.put(element, value);     // Запись слов в мапу
        }
        System.out.println("Count: " + counter);
    }

    /*Задача 2: Найти первый неповторяющийся символ в строке
    Найти первый уникальный символ.*/
    public static void searchElement() {
        Scanner scanner = new Scanner(System.in);
        String str;
        str = scanner.nextLine().toLowerCase();
        if (str.isBlank()) return;
        Map<Character, Integer> symbol = new LinkedHashMap<>();
        for (char strChar : str.toCharArray()) {
            int value = symbol.getOrDefault(strChar, 0) + 1;
            System.out.println(strChar);
            symbol.put(strChar,value);
        }
        for (Map.Entry<Character, Integer> entry : symbol.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("Simbol: " + entry.getKey());
                break;
            }
        }
        System.out.println(symbol);
    }
    /*homework*/

    /*Задача 1: Группировка анаграмм
    Дан список слов. Нужно сгруппировать слова, которые являются анаграммами.
    {"listen", "silent", "enlist", "java", "avaj", "world"}
    */
    public static Map<String, List<String>> groupWordAnagram(String[] words) {
        Map<String, List<String>> anagramWordsGroups = new HashMap<>();

            for (String word : words) {
                // Сортируем буквы в слове
                char[] letters = word.toCharArray();
                Arrays.sort(letters);
                String sortedWord = new String(letters);
                if (!anagramWordsGroups.containsKey(sortedWord)) {
                    anagramWordsGroups.put(sortedWord, new ArrayList<>());
                }
                anagramWordsGroups.get(sortedWord).add(word);
            }
            return anagramWordsGroups;
    }

    /*Задача 2: Поиск первого повторяющегося числа
    Дан список чисел, нужно найти первое число, которое повторяется.*/
    public static int repeatingNumber() {
        int[] numberList = {1,2,3,4,4,5,5,6,7,8,9};
        Set<Integer> seenNumbers = new HashSet<>();
        for (int number : numberList) {
            if (seenNumbers.contains(number)) {
                System.out.println("Number: " + number);
                return number;
            }
            seenNumbers.add(number);
        }
        return 0;
    }
    /*homework*/

}