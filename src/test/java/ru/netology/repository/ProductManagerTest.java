package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class ProductManagerTest {

    /* Так тестирование репозитория работать не будет.

    ProductRepository repo = new ProductRepository(); //Создаём репозиторий, чтобы не создавать его для каждого теста.
    ProductManager manager = new ProductManager(repo); // Создаём менеджер.

    PurchaseItem item1 = new PurchaseItem(11, 1, "Пиво", 100, 150);
    PurchaseItem item2 = new PurchaseItem(222, 22, "Вода", 200, 250);
    PurchaseItem item3 = new PurchaseItem(30, 3, "Сок", 300, 75);

    @BeforeEach // Аннотация junit, позволяющая выполнять метод перед каждым тестом.
    public void setup() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
    }

    @Test
    public void shouldGetAllItems() {
        PurchaseItem[] expected = {item3, item2, item1};
        PurchaseItem[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test // Тест для подсчета общей суммы покупки.
    public void shouldSum() {

        int expected = 600;
        int actual = manager.getTotal();

        Assertions.assertEquals(expected, actual);
    }

     */
    // Заглушки. Mockito.
    // Если мы тестируем только логику менеджера, нет смысла реализовывать для этого отдельный репозиторий.
    // Мы же хотим только убедиться, что если репозиторий отвечает определёнными данными,
    // менеджер будет их обрабатывать строго определённым образом:

    ProductRepository repo = Mockito.mock(ProductRepository.class); // Заглушка для репозитория.
    ProductManager manager = new ProductManager(repo);

    PurchaseItem item1 = new PurchaseItem(11, 1, "Пиво", 1, 150);
    PurchaseItem item2 = new PurchaseItem(222, 22, "Вода", 2, 250);
    PurchaseItem item3 = new PurchaseItem(30, 3, "Сок", 3, 75);

    @Test // Тест для подсчета общей суммы покупки.
    public void shouldSum() {
        PurchaseItem[] items = {item1, item2, item3};
        // Возвращай массив items, когда заглушку repo попросят выполнить команду getItems().
        doReturn(items).when(repo).getItems();

        int expected = 875;
        int actual = manager.getTotal();

        Assertions.assertEquals(expected, actual);
    }
}