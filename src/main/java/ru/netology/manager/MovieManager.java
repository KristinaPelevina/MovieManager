package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.MovieItem;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class MovieManager {
  private MovieItem[] movies = new MovieItem[0];
  private int defaultMovieCount = 10;
  private int movieCount;

  public MovieManager (int movieCount) {
    this.movieCount = movieCount;
  }

  public void movieAdd(MovieItem movie) {
    int length = movies.length + 1;
    MovieItem[] tmp = new MovieItem [length];
    System.arraycopy(movies, 0, tmp, 0, movies.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = movie;
    movies = tmp;
  }

  public MovieItem[] getAll() {
    int requestedMovies = movies.length;

    if (movieCount == 0) {
      if (defaultMovieCount < movies.length) {
        requestedMovies = defaultMovieCount;
      }
    } else {
      if (movieCount < movies.length) {
        requestedMovies = movieCount;
      }
    }
    MovieItem[] result = new MovieItem[requestedMovies];
    for (int f = 0; f < result.length; f++) {
      int index = movies.length - f - 1;
      result[f] = movies[index];
    }
    return result;
  }
}