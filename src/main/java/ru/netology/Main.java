package ru.netology;

import ru.netology.repository.ProductRepository;

/**
 * 14 Исключительные ситуации и их обработка. Тестирование исключений.
 * 14.1 Стектрейс. Перехват ошибок.
 * <p>
 * repo.removeById(13); — несуществующий массив.
 * Когда мы пытаемся в данном случае удалить элемент массива — id 13 (несуществующий элемент массива),
 * то удаление происходит путём созданием нового массива, который выглядит, как старый, но меньше на 1, на тот самый
 * элемент c id 13. Так как, массив пустой, java пытается создать массив длиной -1, здесь и происходит ошибка.
 * <p>
 * Расшифровка сообщения об ошибке в консоли IDE:
 * Exception - исключительная ситуация.
 * in thread "main" - в потоке "main".
 * java.lang.NegativeArraySizeException - название класса исключения, объекта этой ошибки.
 * Create breakpoint (in method ru.netology.repository.ProductRepository.removeById:-1) — здесь не Java, а IDE
 * предлагает поставить точку остановки туда, где была ошибка, в данном случае на метод: repo.removeById(13);
 * В данному слушая ошибка заключается в попытке создать массив отрицательной длины: -1.
 * <p>
 * Далее идёт стектрейс — снимок стека вызовов в момент возникновения ошибки:
 * at ru.netology.repository.ProductRepository.removeById(ProductRepository.java:51)
 * at ru.netology.Main.main(Main.java:18)
 * <p>
 * Управление процессом умирания программы (понятного пользователю сообщения об ошибке).
 * Try - попытайся выполнить следующий метод.
 * Catch - поймай программу в момент умирания с определённым типом ошибки.
 * Если после try ошибки нет, то catch не выполняется.
 * По сути try и catch обрабатывают ошибки и останавливают процесс умирания программы.
 */


public class Main {
    public static void main(String[] args) {
        ProductRepository repo = new ProductRepository();

        try {
            repo.removeById(13);
            System.out.println("Всё в порядке!");
        } catch (NegativeArraySizeException error) {
            System.out.println("Возникла ошибка: " + error.getMessage());
        }
    }
}