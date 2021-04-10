package zhmaylo.Studios.UniversalMovies;

import zhmaylo.MovieGenre.ActionMovie;

/**
 * Класс UniversalActionMovie, реализующий интерфейс ActionMovie.
 *
 * @version 1.0
 * @autor Жмайло Василий
 * @since 09.04.2021
 */
public class UniversalActionMovie implements ActionMovie {
    public UniversalActionMovie() {
        System.out.println("Action movie was created by Universal");
    }
}
