package Four.HomeWork4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock
    private BookRepository mockBockService;
    @InjectMocks
    private BookService bookService;

    @Test
    public void findBookByIdShouldReturnBook() { // Тест на нахождение книги по ID

        when(mockBockService.findById("1")).thenReturn(new Book("1", "Book", "Author"));

        String expectIdBook = "1";
        String actualIdBook = bookService.findBookById("1").getId();

        verify(mockBockService).findById("1");

        assertEquals(expectIdBook, actualIdBook, "Метод findBookById возвращает объект с некорректным ID");
    }

    @Test
    public void findAllBooksShouldReturnListBooks() { // Тест на соответствие списка книг (кол-во в массиве объектов)

        when(mockBockService.findAll())
                .thenReturn(new ArrayList<>(Arrays.asList(
                        new Book("1"),
                        new Book("2"),
                        new Book("3")
                )));

        int expectedSizeListBooks = 5;   // Намеренная ошибка)
        int actualSizeListBooks = bookService.findAllBooks().size();

        verify(mockBockService).findAll();

        assertEquals(expectedSizeListBooks,
                actualSizeListBooks,
                "Метод findAllBooks возвращает некорректный размер списка книг");
    }
}