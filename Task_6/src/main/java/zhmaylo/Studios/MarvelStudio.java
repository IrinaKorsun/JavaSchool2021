package zhmaylo.Studios;

import zhmaylo.MovieGenre.ActionMovie;
import zhmaylo.MovieGenre.Comedy;
import zhmaylo.MovieGenre.HorrorMovie;
import zhmaylo.StudioFactory;
import zhmaylo.Studios.MarvelMovies.MarvelActionMovie;
import zhmaylo.Studios.MarvelMovies.MarvelComedy;
import zhmaylo.Studios.MarvelMovies.MarvelHorrorMovie;

/**
 * Класс MarvelStudio, реализующий интерфейс StudioFactory.
 *
 * @version 1.0
 * @autor Жмайло Василий
 * @since 09.04.2021
 */
public class MarvelStudio implements StudioFactory {

    @Override
    public void CreationReport() {
        System.out.println("Marvel studio was created and starts making movies!");
    }

    @Override
    public ActionMovie createActionMovie() {
        return new MarvelActionMovie();
    }

    @Override
    public Comedy createComedy() {
        return new MarvelComedy();
    }

    @Override
    public HorrorMovie createHorrorMovie() {
        return new MarvelHorrorMovie();
    }
}
