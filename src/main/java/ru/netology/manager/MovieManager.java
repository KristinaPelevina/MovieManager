package ru.netology.manager;

import ru.netology.domain.MovieItem;
import ru.netology.repository.MovieRepository;

public class MovieManager {
  private MovieRepository repository;
  private int defaultMovieCount = 10;
  private int movieCount;

  public MovieManager(MovieRepository repository) {
    this.repository = repository;
  }

  public MovieManager(MovieRepository repository, int movieCount) {
    this.repository = repository;
    this.movieCount = movieCount;
  }

  public void movieAdd(MovieItem movie) {
    repository.save(movie);
  }

  public MovieItem[] getAll() {
    MovieItem[] movieRepository = repository.findAll();
    int requestedMovies = movieRepository.length;

    if (movieCount == 0) {
      if (defaultMovieCount < movieRepository.length) {
        requestedMovies = defaultMovieCount;
      }
    } else {
      if (movieCount < movieRepository.length) {
        requestedMovies = movieCount;
      }
    }

    MovieItem[] result = new MovieItem[requestedMovies];
    for (int f = 0; f < result.length; f++) {
      int index = movieRepository.length - f - 1;
      result[f] = movieRepository[index];
    }
    return result;
  }
}