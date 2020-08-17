package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerDefaultTest {
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
  private MovieItem eleventh = new MovieItem(11, "Довод", "боевик");

  @BeforeEach
  public void setUp() {
    manager = new MovieManager();
  }

  @Test
  public void shouldAddFilms() {
    manager.movieAdd(first);
    manager.movieAdd(second);
    manager.movieAdd(third);
    manager.movieAdd(fourth);
    manager.movieAdd(fifth);
    manager.movieAdd(sixth);
    manager.movieAdd(seventh);
    manager.movieAdd(eighth);
    manager.movieAdd(ninth);
    manager.movieAdd(tenth);
    MovieItem[] expected = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
    MovieItem[] actual = manager.getMovies();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldAddMoreDefault() {
    manager.movieAdd(first);
    manager.movieAdd(second);
    manager.movieAdd(third);
    manager.movieAdd(fourth);
    manager.movieAdd(fifth);
    manager.movieAdd(sixth);
    manager.movieAdd(seventh);
    manager.movieAdd(eighth);
    manager.movieAdd(ninth);
    manager.movieAdd(tenth);
    manager.movieAdd(eleventh);
    MovieItem[] expected = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
    MovieItem[] actual = manager.getMovies();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldDisplayLastTenIfTen() {
    manager.movieAdd(first);
    manager.movieAdd(second);
    manager.movieAdd(third);
    manager.movieAdd(fourth);
    manager.movieAdd(fifth);
    manager.movieAdd(sixth);
    manager.movieAdd(seventh);
    manager.movieAdd(eighth);
    manager.movieAdd(ninth);
    manager.movieAdd(tenth);
   MovieItem[] expected = new MovieItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
    MovieItem[] actual = manager.getAll();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldDisplayLastTenIfMore() {
    manager.movieAdd(first);
    manager.movieAdd(second);
    manager.movieAdd(third);
    manager.movieAdd(fourth);
    manager.movieAdd(fifth);
    manager.movieAdd(sixth);
    manager.movieAdd(seventh);
    manager.movieAdd(eighth);
    manager.movieAdd(ninth);
    manager.movieAdd(tenth);
    manager.movieAdd(eleventh);
    MovieItem[] expected = new MovieItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
    MovieItem[] actual = manager.getAll();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldDisplayOneIfOne() {
    manager.movieAdd(first);
    MovieItem[] expected = new MovieItem[]{first};
    MovieItem[] actual = manager.getAll();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldNotDisplayFilmsIfNoFilms() {
    MovieItem[] expected = new MovieItem[]{};
    MovieItem[] actual = manager.getAll();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldDisplayTenByDefaultIfZero() {
    manager = new MovieManager(0);
    manager.movieAdd(first);
    manager.movieAdd(second);
    manager.movieAdd(third);
    manager.movieAdd(fourth);
    manager.movieAdd(fifth);
    manager.movieAdd(sixth);
    manager.movieAdd(seventh);
    manager.movieAdd(eighth);
    manager.movieAdd(ninth);
    manager.movieAdd(tenth);
    MovieItem[] expected = new MovieItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
    MovieItem[] actual = manager.getAll();
    assertArrayEquals(expected, actual);
  }
}