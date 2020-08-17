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
public class MovieManagerContainsMoreMoviesTest {
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
    private MovieItem tenth = new MovieItem(10, "Фрсаж 10", "драма");
    private MovieItem eleventh = new MovieItem(11, "Черная вдова", "комиксы");
    private MovieItem twelfth = new MovieItem(12, "Новые мутанты", "комиксы");
    private MovieItem thirteenth = new MovieItem(13, "Чудо-женщина.1984", "комиксы");
    private MovieItem fourteenth = new MovieItem(14, "Начало", "фантастика");
    private MovieItem fifteenth = new MovieItem(15, "Мулан", "приключения");
    private MovieItem sixteen = new MovieItem(16, "Проклятие монахини Роуз", "ужасы");


    @BeforeEach
    public void setUp() {
        manager = new MovieManager(repository, 15);
    }

    @Test
    public void shouldDisplayLastFifteenIfFifteen() {
        MovieItem[] returned = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth};
        doReturn(returned).when(repository).findAll();

        MovieItem[] expected = new MovieItem[]{fifteenth, fourteenth, thirteenth, twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldDisplayLastFifteenIfMoreFifteen() {
        MovieItem[] returned = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteen};
        doReturn(returned).when(repository).findAll();

        MovieItem[] expected = new MovieItem[]{sixteen, fifteenth, fourteenth, thirteenth, twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}




