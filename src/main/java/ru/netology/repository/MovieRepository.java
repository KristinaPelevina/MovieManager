package ru.netology.repository;

import ru.netology.domain.MovieItem;

public class MovieRepository {
    private MovieItem[] movies = new MovieItem[0];

    public MovieItem[] findAll() {
        return movies;
    }

    public void save(MovieItem film) {
        int length = movies.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        movies = tmp;
    }

    public MovieItem findById(int id) {
        for (MovieItem film : movies) {
            if (film.getId() == id) {
                return film;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        MovieItem[] tmp = new MovieItem[length];
        int index = 0;
        for (MovieItem film : movies) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        movies = tmp;
    }

    public void removeAll() {
        movies = new MovieItem[0];
    }
}