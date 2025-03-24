package lesson15;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        clothingVariable();
        withdrawMoney();
        ResourceProtection();
        AttemptTtoTakeOverTheLock();
       // WaitingForAllThreadsToComplete();
        threadGroupSynchronization();
        queueThreads();
        useCyclicBarrier();
        pool();
        queueThreads();
    }

   /* Задача 1: Проблема видимости переменной между потоками
    Создай класс Counter, в котором один поток увеличивает volatile int count, а другой
    поток ждет, пока count достигнет 10, и затем выводит "Достигнуто 10".*/

    public static void clothingVariable() {
        Counter counter = new Counter();
        Thread threadClothingVariable = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread threadClothingVariableSecond = new Thread(() -> {
            while (counter.getCount() < 10) {
            }
            System.out.println("Count = " + counter.getCount());
        });

        threadClothingVariable.start();
        threadClothingVariableSecond.start();
    }
    /*Задача 2: Монитор объекта
    Реализуй класс BankAccount, в котором два потока одновременно пытаются снять
    деньги. Используй synchronized, чтобы избежать состояния гонки.*/

    public static void withdrawMoney() {
        BankAccount balance = new BankAccount();
        Thread withdrawMoneyFirst = new Thread(() -> {
            balance.withdraw(700);
            System.out.println(Thread.currentThread().getName() + " БАЛАНС: " + balance.getBalance());
        });

        Thread withdrawMoneySecond = new Thread(() -> {
            balance.withdraw(500);
            System.out.println(Thread.currentThread().getName() + " БАЛАНС: " + balance.getBalance());
        });
        withdrawMoneyFirst.start();
        withdrawMoneySecond.start();
    }

   /*Задача 3: Защита ресурса
    Создай класс SharedResource, к которому могут обращаться несколько потоков.
    Используй ReentrantLock, чтобы предотвратить одновременный доступ*/
   public static void ResourceProtection() {
       SharedResource newSharedResources = new SharedResource();
       Thread resourceProtectionFirst = new Thread(newSharedResources::block);
       Thread resourceProtectionSecond = new Thread(newSharedResources::block);
       resourceProtectionFirst.start();
       resourceProtectionSecond.start();
   }

   /* Задача 4: Попытка захвата блокировки
    Напиши программу, где два потока пытаются одновременно захватить ReentrantLock.
    Один поток использует tryLock() и, если не может захватить, выполняет другую работу.*/

    public static void AttemptTtoTakeOverTheLock () {
        SharedResource newSharedResources = new SharedResource();
        Thread attemptTtoTakeOverTheLockFirst = new Thread(newSharedResources::block);
        Thread attemptTtoTakeOverTheLockSecond = new Thread(newSharedResources::block);
        attemptTtoTakeOverTheLockFirst.start();
        attemptTtoTakeOverTheLockSecond.start();

    }

    /*Задача 5: Ожидание выполнения всех потоков
    Запусти 5 потоков, каждый из которых выполняет задачу 2 секунды, а затем
    вызывает countDown(). Основной поток должен дождаться всех потоков перед
    продолжением.*/

    public static void WaitingForAllThreadsToComplete() throws InterruptedException {
        final int THREAD_COUNT = 5;
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadId = i;
            new Thread(() -> {
                try {
                    System.out.println("Поток " + threadId + " начал выполнение задачи");
                    Thread.sleep(1000);
                    System.out.println("Поток " + threadId + " завершил задачу");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }).start();
        }
        System.out.println("Основной поток ожидает завершения всех потоков");
        latch.await();
        System.out.println("Все потоки завершили работу. Основной поток продолжает выполнение.");
    }

    /*Задача 6: Синхронизация группы потоков
        Реализуй программу, где 3 потока выполняют работу и ждут друг друга на
     CyclicBarrier. Когда все потоки достигли барьера, они продолжают выполнение.*/
    public static void threadGroupSynchronization() {
        final int THREAD_COUNT_TREE = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_COUNT_TREE);
        for (int i = 0; i < THREAD_COUNT_TREE; i++) {
            final int threadId = i;
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
    /*Задача 8: Пул потоков
    Используй ThreadPoolExecutor для обработки 10 задач, каждая из которых
    выполняется 1 секунду.*/
    public static void pool() {
        final int THREAD_COUNT_TEN = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT_TEN);
        for (int i = 0; i < THREAD_COUNT_TEN; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " запущен...");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
    }

    /*
   Задача 9: Потокобезопасная очередь
   Реализуй очередь с BlockingQueue, куда один поток добавляет элементы, а другой
   извлекает их с интервалом в 1 секунду.
    */
    public static void queueThreads() {

        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);
        Thread queueThreadsFirst = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    queue.put(i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    Integer item = queue.take();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        queueThreadsFirst.start();
        consumer.start();
    }

    /*
    Задача 10: Использование CyclicBarrier для синхронизации нескольких потоков.
    Есть 4 потока, каждый из которых выполняет часть задачи. Все потоки должны завершить
    свои работы, прежде чем главный поток продолжит выполнение. Нужно синхронизировать
    потоки так, чтобы они все начинали работать одновременно и завершили выполнение
    одновременно.
     */
    public static void useCyclicBarrier() {
        final int COUNT_TEN_FOUR = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(COUNT_TEN_FOUR);
        Runnable work = () -> {
            System.out.println(Thread.currentThread().getName() + " WORK");
            Random random = new Random();
            try {
                Thread.sleep(1000 + random.nextInt(500, 5000));
                System.out.println(Thread.currentThread().getName() + " WAIT");
                cyclicBarrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " CONTINUES");
        };
        new Thread(work).start();
        new Thread(work).start();
        new Thread(work).start();
        new Thread(work).start();
    }
}

/*Задача 7: Ограниченный доступ к ресурсу
Создай класс ParkingLot с Semaphore(3), где 5 машин пытаются припарковаться, но
одновременно могут занять только 3 места.*/
class ParkingLot {
    private static final int PARKING_SPOTS = 3;
    private static final int CARS = 5;
    private final Semaphore semaphore = new Semaphore(PARKING_SPOTS, true); // Fair semaphore
    public void park(int carId) {
        ParkingLot parkingLot = new ParkingLot();
        for (int i = 1; i <= CARS; i++) {
            Thread car = new Thread(new Car(i, parkingLot));
            car.start();
        }
        try {
            System.out.println("Машина " + carId + " подъехала к парковке.");
            semaphore.acquire();

            System.out.println("Машина " + carId + " припарковалась");
            Thread.sleep((long) (Math.random() * 5000));

            System.out.println("Машина " + carId);
            semaphore.release();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Машина " + carId);
        }
    }

    static class Car implements Runnable {
        private final int carId;
        private final ParkingLot parkingLot;

        public Car(int carId, ParkingLot parkingLot) {
            this.carId = carId;
            this.parkingLot = parkingLot;
        }

        @Override
        public void run() {
            parkingLot.park(carId);
        }
    }
}









class Counter {
    private volatile int count;

    void increment () {
        count++;
        System.out.println(count);
    }

    void decrement () {
        count--;
        System.out.println(count);
    }

    int getCount() {
        return count;
    }
}

class BankAccount {
    private int balance;

    synchronized void withdraw(int number) {
        if (balance < number) {
            System.out.println("Нет средств");
        } else {
            balance -= number;
        }
    }

    int getBalance() {
        return balance;
    }
}

class SharedResource {
    private final ReentrantLock lock = new ReentrantLock();

    public void block() {
        if(lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + " ЗАКРЫТО");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " ОШИБКА");
        }
    }
}






