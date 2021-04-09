package zhmaylo.Studios;

import zhmaylo.MovieGenre.ActionMovie;
import zhmaylo.MovieGenre.Comedy;
import zhmaylo.MovieGenre.HorrorMovie;
import zhmaylo.StudioFactory;
import zhmaylo.Studios.UniversalMovies.UniversalActionMovie;
import zhmaylo.Studios.UniversalMovies.UniversalHorrorMovie;
import zhmaylo.Studios.UniversalMovies.UniversalComedy;

/**
 * Класс UniversalStudio, реализующий интерфейс StudioFactory.
 *
 * @version 1.0
 * @autor Жмайло Василий
 * @since 09.04.2021
 */
public class UniversalStudio implements StudioFactory {

    @Override
    public void CreationReport() {
        System.out.println("Universal studio was created and starts making movies!");
    }

    @Override
    public ActionMovie createActionMovie() {
        return new UniversalActionMovie();
    }

    @Override
    public Comedy createComedy() {
        return new UniversalComedy();
    }

    @Override
    public HorrorMovie createHorrorMovie() {
        return new UniversalHorrorMovie();
    }

}
