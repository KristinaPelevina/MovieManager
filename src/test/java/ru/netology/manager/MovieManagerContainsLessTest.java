package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieItem;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MovieManagerContainsLessTest {

    @Mock
    private MovieRepository repository;
    @InjectMocks
    private MovieManager manager = new MovieManager(repository);
    private MovieItem first = new MovieItem(1, "Бладшот", "боевик");
    private MovieItem second = new MovieItem(2, "Вперёд", "мультфильм");
    private MovieItem third = new MovieItem(3, "Отель «Белград»", "комедия");
    private MovieItem fourth = new MovieItem(4, "Джентльмены", "боевик");
    private MovieItem fifth = new MovieItem(5, "Человек-невидимка", "ужасы");
    private MovieItem sixth = new MovieItem(6, "Тролли. Мировой тур", "мультфильм");
    private MovieItem seventh = new MovieItem(7, "Номер один", "комедия");
    private MovieItem eighth = new MovieItem(8, "Тихое место 2", "ужасы");
    private MovieItem ninth = new MovieItem(9, "Довод", "фантастика");
    private MovieItem tenth = new MovieItem(10, "Форсаж 10", "драма");

    @BeforeEach
    public void setUp() {
        manager = new MovieManager(repository, 5);
    }

    @Test
    public void shouldDisplayLastFiveIfFive() {
        MovieItem[] returned = new MovieItem[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        MovieItem[] expected = new MovieItem[]{fifth, fourth, third, second, first};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldDisplayLastFiveIfMoreFive() {
        MovieItem[] returned = new MovieItem[]{sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();

        MovieItem[] expected = new MovieItem[]{tenth, ninth, eighth, seventh, sixth};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}