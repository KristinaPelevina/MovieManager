
package ru.netology.repository;

import ru.netology.domain.MovieItem;

public class MovieRepository {
    private MovieItem[] movies = new MovieItem[0];

    public MovieItem[] findAll() {
        return movies;
    }

    public void save(MovieItem movie) {
        int length = movies.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public MovieItem findById(int id) {
        for (MovieItem movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        MovieItem[] tmp = new MovieItem[length];
        int index = 0;
        for (MovieItem movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    public void removeAll() {
        movies = new MovieItem[0];
    }
}