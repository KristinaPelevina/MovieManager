package ru.netology.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {
    MovieRepository repository = new MovieRepository();
    private MovieItem first = new MovieItem(1, "Бладшот", "боевик");
    private MovieItem second = new MovieItem(2, "Вперёд", "мультфильм");
    private MovieItem third = new MovieItem(3, "Отель «Белград»", "комедия");
    private MovieItem fourth = new MovieItem(4, "Джентльмены", "боевик");
    private MovieItem fifth = new MovieItem(5, "Человек-невидимка", "ужасы");
    private MovieItem sixth = new MovieItem(6, "Тролли. Мировой тур", "мультфильм");
    private MovieItem seventh = new MovieItem(7, "Номер один", "комедия");
    private MovieItem eighth = new MovieItem(8, "Тихое место 2", "ужасы");
    private MovieItem ninth = new MovieItem(9, "Довод","фантастика");
    private MovieItem tenth = new MovieItem(10,"Форсаж 10","драма");

    @Test
    public void shouldFindAllMovies() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
        MovieItem[] expected = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        MovieItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyIfNoMovies() {
        MovieItem[] expected = new MovieItem[]{};
        MovieItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveMovies() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        MovieItem[] expected = new MovieItem[]{first, second, third, fourth, fifth};
        MovieItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindIfMovieExists() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        int requestedId = 4;
        repository.findById(requestedId);
        MovieItem expected = fourth;
        MovieItem actual = repository.findById(requestedId);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullIfMovieNotExists() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        int requestedId = 6;
        repository.findById(requestedId);
        MovieItem expected = null;
        MovieItem actual = repository.findById(requestedId);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExists() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        int removeId = 5;
        repository.removeById(removeId);
        MovieItem[] actual = repository.findAll();
        MovieItem[] expected = new MovieItem[]{first, second,third, fourth};
        assertArrayEquals(expected, actual);
    }

    @Disabled
    @Test
    public void shouldNotRemoveIfNotExists() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        int removeId = 6;
        repository.removeById(removeId);
        MovieItem[] expected = new MovieItem[]{first, second,third, fourth, fifth};
        MovieItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.removeAll();
        MovieItem[] expected = new MovieItem[]{};
        MovieItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}