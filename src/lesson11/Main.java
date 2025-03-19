package lesson11;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // deleteDuplicate();
        // reserveLinkedList(addLinkList());
        // deleteIteration();
        // circleOfPeople();
        // LinkedList<Integer> list1 = new LinkedList<>();
        // list1.add(1);
        // LinkedList<Integer> list2 = new LinkedList<>();
        // list2.add(2);
        // LinkedList<Integer> mergedList = mergeLists(list1, list2);
        // System.out.println("Done" + mergedList);
    }

    /* Задача 1 Удаление дубликатов из ArrayList
    Дан ArrayList<Integer>, содержащий дубликаты. Удалите все дубликаты, сохраняя порядок элементов.*/
    public static void deleteDuplicate(ArrayList<Integer> arrayList) {
        ArrayList<Integer> arrayList1 = addElements();
        for (int i = 0; i < arrayList1.size(); i++) {
            for (int j = i + 1; j < arrayList1.size(); j++) {
                if (arrayList1.get(i).equals(arrayList1.get(j))) {
                    arrayList1.remove(j);
                    j--;
                }

            }
        }
        System.out.println(arrayList);
    }

    public static ArrayList<Integer> addElements() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            arrayList.add(random.nextInt(0, 10));
        }
        return arrayList;
    }


    /*Задача 2
    Разворот LinkedList
    Разверните LinkedList без использования Collections.reverse().*/
    public static LinkedList<Integer> addLinkList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            linkedList.add(rand.nextInt(0, 10));
        }
        System.out.println(linkedList);
        return linkedList;
    }

    public static void reserveLinkedList(LinkedList<Integer> linkedList) {
        System.out.println("Изначальный " + linkedList);
        int buff = 0;
        for (int i = 0; i < linkedList.size(); i++) {
            for (int j = linkedList.size() - 1; j > i; j++) {
                System.out.println("Элемент i = " + linkedList.get(i) + "Элемент j = " + linkedList.get(j) + "i = " + i + "i = " + j);
                buff = linkedList.get(i);
                linkedList.set(j, linkedList.get(j));
                linkedList.set(j, buff);
                System.out.println(linkedList);
            }
        }
        System.out.println(linkedList);
    }
    /*Задача 3: Итератор и удаление по условию
    Дан ArrayList<Integer>. Используйте Iterator, чтобы удалить все числа, кратные 3*/

    public static void deleteIteration(ArrayList<Integer> arrayList) {
        ArrayList<Integer> arrayListNumber = new ArrayList<>();
        arrayListNumber.add(1);
        arrayListNumber.add(3);
        arrayListNumber.add(5);
        arrayListNumber.add(7);
        System.out.println("The original list: " + arrayListNumber);
        // Добавили числа в лист

        Iterator<Integer> deleteIterator = arrayListNumber.iterator();
        while (deleteIterator.hasNext()) {
            Integer number = deleteIterator.next();
            if (number % 3 == 0) {
                deleteIterator.remove();
            }
            System.out.println("Done: " + deleteIterator);
            // Удаление числа с проверкой с циклом
        }

    }

    /*homework*/

        /*Задача 1: Последний оставшийся элемент (LinkedList)
        В круге из n человек каждый 2-й выбывает, пока не останется один. Используйте
        LinkedList для моделирования
        */

    public static void circleOfPeople (LinkedList linkedList) {
        int people = 7;

        LinkedList<Integer> circlePeople = new LinkedList<>();

        for (int i = 1; i <= people; i++) {
            circlePeople.add(i);
        }
        System.out.println("Circle: " + circlePeople);

        ListIterator<Integer> iterator = circlePeople.listIterator();
        while (circlePeople.size() > 1) {
            if (!iterator.hasNext()) {
                iterator = circlePeople.listIterator();
            }
            iterator.next();

            if (!iterator.hasNext()) {
                iterator = circlePeople.listIterator();
            }
            iterator.next();
            iterator.remove();
            System.out.println("Circle delete: " + circlePeople);
        }
        System.out.println("Last element " + circlePeople.getFirst());
    }

    /*Задача 2: Слияние двух отсортированных LinkedList в один (без Set, Map)
    Даны два отсортированных LinkedList, нужно слить их в один отсортированный
    список.*/

    public static LinkedList<Integer> mergeLists(LinkedList<Integer> listMergeFirst, LinkedList<Integer> listMergeSecond) {

        LinkedList<Integer> mergedList = new LinkedList<>();

        Iterator<Integer> iterationMergeFirst = listMergeFirst.iterator();
        Iterator<Integer> iterationMergeSecond = listMergeSecond.iterator();

        Integer currentFirst = null;
        Integer currentSecond = null;

        if (iterationMergeFirst.hasNext()) {
            currentFirst = iterationMergeFirst.next();
        }
        if (iterationMergeSecond.hasNext()) {
            currentSecond = iterationMergeSecond.next();
        }


        while (currentFirst != null && currentSecond != null) {
            if (currentFirst < currentSecond) {
                mergedList.add(currentFirst);
                currentFirst = iterationMergeFirst.hasNext() ? iterationMergeFirst.next() : null;
            } else {
                mergedList.add(currentSecond);
                currentSecond = iterationMergeSecond.hasNext() ? iterationMergeSecond.next() : null;
            }
        }

        while (currentFirst != null) {
            mergedList.add(currentFirst);
            currentFirst = iterationMergeFirst.hasNext() ? iterationMergeFirst.next() : null;
        }

        while (currentSecond != null) {
            mergedList.add(currentSecond);
            currentSecond = iterationMergeSecond.hasNext() ? iterationMergeSecond.next() : null;
        }
            return mergedList;
        }
}





