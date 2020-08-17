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
public class MovieManagerDefaultTest {
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
  private MovieItem eleventh = new MovieItem(11, "Черная вдова", "комиксы");

  @BeforeEach
  public void setUp() {
    manager = new MovieManager(repository);
  }

  @Test
  public void shouldAddMovies() {
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
    MovieItem[] returned = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
    doReturn(returned).when(repository).findAll();

    MovieItem[] expected = new MovieItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
    MovieItem[] actual = manager.getAll();
    assertArrayEquals(expected, actual);

    verify(repository).findAll();
  }

  @Test
  public void shouldDisplayLastTenIfTen() {
    MovieItem[] returned = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
    doReturn(returned).when(repository).findAll();

    MovieItem[] expected = new MovieItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
    MovieItem[] actual = manager.getAll();
    assertArrayEquals(expected, actual);

    verify(repository).findAll();
  }

  @Test
  public void shouldDisplayLastTenIfMore() {
    MovieItem[] returned = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
    doReturn(returned).when(repository).findAll();

    MovieItem[] expected = new MovieItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
    MovieItem[] actual = manager.getAll();
    assertArrayEquals(expected, actual);

    verify(repository).findAll();
  }

  @Test
  public void shouldDisplayOneIfOne() {
    MovieItem[] returned = new MovieItem[]{first};
    doReturn(returned).when(repository).findAll();

    MovieItem[] expected = new MovieItem[]{first};
    MovieItem[] actual = manager.getAll();
    assertArrayEquals(expected, actual);

    verify(repository).findAll();
  }

  @Test
  public void shouldNotDisplayMoviesIfNoMovies() {
    MovieItem[] returned = new MovieItem[]{};
    doReturn(returned).when(repository).findAll();

    MovieItem[] expected = new MovieItem[]{};
    MovieItem[] actual = manager.getAll();
    assertArrayEquals(expected, actual);

    verify(repository).findAll();
  }

  @Test
  public void shouldDisplayTenByDefaultIfZero() {
    manager = new MovieManager(repository,0);
    MovieItem[] returned = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
    doReturn(returned).when(repository).findAll();

    MovieItem[] expected = new MovieItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
    MovieItem[] actual = manager.getAll();
    assertArrayEquals(expected, actual);
  }
}