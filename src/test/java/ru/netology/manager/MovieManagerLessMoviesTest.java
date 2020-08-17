package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerLessMoviesTest {
    private MovieManager manager;
    private MovieItem first = new MovieItem(1, "Бладшот", "боевик");
    private MovieItem second = new MovieItem(2, "Вперёд", "мультфильм");
    private MovieItem third = new MovieItem(3, "Отель «Белград»", "комедия");
    private MovieItem fourth = new MovieItem(4, "Джентльмены", "боевик");
    private MovieItem fifth = new MovieItem(5, "Человек-невидимка", "ужасы");
    private MovieItem sixth = new MovieItem(6, "Тролли. Мировой тур", "мультфильм");
    private MovieItem seventh = new MovieItem(7, "Номер один", "комедия");
    private MovieItem eighth = new MovieItem(8, "Тихое место 2", "триллер");
    private MovieItem ninth = new MovieItem(9, "Мулан", "приключения");
    private MovieItem tenth = new MovieItem(10, "Форсаж 10", "драма");

    @BeforeEach
    public void setUp() {
        manager = new MovieManager(5);
        manager.movieAdd(first);
        manager.movieAdd(second);
        manager.movieAdd(third);
    }

    @Test
    public void shouldDisplayLastFiveIfFive() {
        manager.movieAdd(fourth);
        manager.movieAdd(fifth);
        MovieItem[] expected = new MovieItem[]{fifth, fourth, third, second, first};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDisplayLastFiveIfMoreFive() {
        manager.movieAdd(sixth);
        manager.movieAdd(seventh);
        manager.movieAdd(eighth);
        manager.movieAdd(ninth);
        manager.movieAdd(tenth);
        MovieItem[] expected = new MovieItem[]{tenth, ninth, eighth, seventh, sixth};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}