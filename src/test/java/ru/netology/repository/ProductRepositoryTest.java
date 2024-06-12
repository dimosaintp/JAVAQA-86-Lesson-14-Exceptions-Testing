package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;

public class ProductRepositoryTest {

    PurchaseItem item1 = new PurchaseItem(11, 1, "Пиво", 100, 150);
    PurchaseItem item2 = new PurchaseItem(222, 22, "Вода", 200, 250);
    PurchaseItem item3 = new PurchaseItem(30, 3, "Сок", 300, 75);

    @Test // Проверяем, что в репозиторий добавлены item1, item2, item3.
    public void testAdd() {
        ProductRepository repo = new ProductRepository();
        // Добавляем элементы в репозиторий.
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        PurchaseItem[] expected = {item1, item2, item3};
        PurchaseItem[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверяем, что из репозитория удалили item2.
    public void testDelete() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.removeById(item2.getId());

        PurchaseItem[] expected = {item1, item3};
        PurchaseItem[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверяем, NegativeIdException, просим удалить элемент -100.
    public void testException() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        Assertions.assertThrows(NegativeIdException.class, () -> repo.removeById(-100));
    }
}