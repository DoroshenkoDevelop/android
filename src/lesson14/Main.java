package lesson14;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        int count = counter.getIncrement();
        Thread myThread = new Thread(() -> {
            for (int i = 0; i < 100; i++){
                counter.increment();
            }
        });
        Thread myThread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++){
                counter.increment();
            }
        });
        myThread.start();
        myThread.join();
        myThread2.start();
        myThread2.join();
        System.out.println(counter.getIncrement());

        Count count1 = new Count();
        Thread myThread3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                count1.increment();
            }
        });

        Thread myThread6 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Поток 1");
            }
        });

        Thread myThread7 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Поток 2");
            }
        });
        myThread6.start();
        myThread6.join();
        myThread7.start();
        myThread7.join();
    }

    /*Задача 4: Использование атомарного типа AtomicInteger
    Задание: Используйте AtomicInteger для безопасного увеличения счетчика в многозадачной среде.*/
    public static void  automaticCreate() throws InterruptedException {
        AtomicInteger num = new AtomicInteger(0);

        Thread myThread4 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                num.incrementAndGet();
            }
        });
        Thread myThread5 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                num.incrementAndGet();
            }
        });
        myThread4.start();
        myThread5.start();
        myThread4.join();
        myThread5.join();
        System.out.println("Final" + num.get());
    }

    /*Задача 3: Синхронизация потоков для предотвращения гонки данных
Описание: Напишите программу с двумя потоками, которые одновременно
увеличивают и уменьшают значение счетчика. Ваша задача — обеспечить, чтобы
операция увеличения и уменьшения была выполнена безопасно с помощью
синхронизации.*/
    /*homework*/

    public static void racePrevention() {
        AtomicInteger number = new AtomicInteger(0);
        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                number.incrementAndGet();
            }
        };

        Runnable decrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                number.decrementAndGet();
            }
        };
        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(decrementTask);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /*homework*/
}

/*
Задача 1:Создание потока с использованием класса Thread
Задание: Создайте класс Counter, который будет увеличивать счетчик на 1 в каждом потоке, используя класс Thread.*/
class Counter {
    int count;

    void increment() {
        count++;
        System.out.println(count + " " + Thread.currentThread().getName());
    }
    public int getIncrement() {
        return count;
    }

}
/*Задание2: Реализуйте интерфейс Runnable, который будет выводить номер потока 100 раз.*/
class MyRunnableTreads implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Поток " + ": " + i);
        }
    }
}
/*
Задача 3: Синхронизация потоков с использованием ключевого слова synchronized
Задание: Создайте два потока, которые одновременно увеличивают значение переменной. Синхронизируйте доступ к этой переменной.*/
class Count {
    public int count;
    public synchronized void increment () {
        count++;
        System.out.println(count);
    }
    public int getCount() {
        return count;
    }
}


/*homework*/
/*Домашнее задание
Задача 1: Синхронизация доступа к счетчику с помощью внешнего объекта
Описание: Вам нужно создать класс Counter, который будет иметь метод increment и
метод decrement. Эти методы должны увеличивать и уменьшать значение переменной
count в многопоточном режиме. Для синхронизации доступов используйте внешний
объект (не объект класса).*/
class CounterSecond {
    private int count = 0;
    private final Lock lock;

    public CounterSecond(Lock lock) {
        this.lock = lock;
    }


    public void increment() {
        lock.lock();
        try {
            count++;
            System.out.println("Incremented: " + count);
        } finally {
            lock.unlock();
        }
    }


    public void decrement() {
        lock.lock();
        try {
            count--;
            System.out.println("Decremented: " + count);
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}

/*Задача 2: Применение атомарных типов для безопасного увеличения счетчика
Описание: Напишите программу, в которой два потока одновременно увеличивают
счетчик. Вместо синхронизации используйте класс AtomicInteger, чтобы избежать
блокировок*/
class AtomicCounter {
    public final AtomicInteger count = new AtomicInteger(0);
    public void increment() {
        int newValue = count.incrementAndGet();
        System.out.println("Инкремент: " + newValue);
    }
    public int getCount() {
        return count.get();
    }
    public static void main(String[] args) {
        AtomicCounter counter = new AtomicCounter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Счет: " + counter.getCount());
    }
}
/*homework*/


