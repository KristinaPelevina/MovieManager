package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerContainsMoreMoviesTest {
  private MovieManager manager;
  private MovieItem first = new MovieItem(1, "Бладшот", "боевик");
  private MovieItem second = new MovieItem(2, "Вперёд", "мультфильм");
  private MovieItem third = new MovieItem(3, "Отель «Белград»", "комедия");
  private MovieItem fourth = new MovieItem(4, "Джентльмены", "боевик");
  private MovieItem fifth = new MovieItem(5, "Человек-невидимка", "ужасы");
  private MovieItem sixth = new MovieItem(6, "Тролли. Мировой тур", "мультфильм");
  private MovieItem seventh = new MovieItem(7, "Номер один", "комедия");
  private MovieItem eighth = new MovieItem(8, "Тихое место 2", "фантастика");
  private MovieItem ninth = new MovieItem(9, "Мулан", "ужасы");
  private MovieItem tenth = new MovieItem(10, "Форсаж 10", "драма");
  private MovieItem eleventh = new MovieItem(11, "Довод", "фантастика");
  private MovieItem twelfth = new MovieItem(12,"Черная вдова","комиксы");
  private MovieItem thirteenth = new MovieItem(13,"Новые мутанты","фантастика");
  private MovieItem fourteenth = new MovieItem(14,"Начало","фантастика");
  private MovieItem fifteenth = new MovieItem(15,"Чудо-женщина.1984","комиксы");
  private MovieItem sixteen = new MovieItem(16,"Проклятие монахини Роуз","ужасы");


  @BeforeEach
  public void setUp() {
    manager = new MovieManager(15);
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
    manager.movieAdd(twelfth);
    manager.movieAdd(thirteenth);
    manager.movieAdd(fourteenth);
    manager.movieAdd(fifteenth);
  }

  @Test
  public void shouldDisplayLastFifteenIfFifteen() {
    MovieItem[] expected = new MovieItem[]{fifteenth, fourteenth, thirteenth, twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
    MovieItem[] actual = manager.getAll();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldDisplayLastFifteenIfMoreFifteen() {
    manager.movieAdd(sixteen);
    MovieItem[] expected = new MovieItem[]{sixteen, fifteenth, fourteenth, thirteenth, twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
    MovieItem[] actual = manager.getAll();
    assertArrayEquals(expected, actual);
  }
}
