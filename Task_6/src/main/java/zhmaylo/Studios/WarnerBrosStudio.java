package zhmaylo.Studios;

import zhmaylo.MovieGenre.ActionMovie;
import zhmaylo.MovieGenre.Comedy;
import zhmaylo.MovieGenre.HorrorMovie;
import zhmaylo.StudioFactory;
import zhmaylo.Studios.WarnerBrosMovies.WarnerBrosActionMovie;
import zhmaylo.Studios.WarnerBrosMovies.WarnerBrosComedy;
import zhmaylo.Studios.WarnerBrosMovies.WarnerBrosHorrorMovie;

/**
 * Класс WarnerBrosStudio, реализующий интерфейс StudioFactory.
 *
 * @version 1.0
 * @autor Жмайло Василий
 * @since 09.04.2021
 */
public class WarnerBrosStudio implements StudioFactory {

    @Override
    public void CreationReport() {
        System.out.println("WarnerBros studio was created and starts making movies!");
    }

    @Override
    public ActionMovie createActionMovie() {
        return new WarnerBrosActionMovie();
    }

    @Override
    public Comedy createComedy() {
        return new WarnerBrosComedy();
    }

    @Override
    public HorrorMovie createHorrorMovie() {
        return new WarnerBrosHorrorMovie();
    }

}
