package zhmaylo;

import zhmaylo.MovieGenre.ActionMovie;
import zhmaylo.MovieGenre.Comedy;
import zhmaylo.MovieGenre.HorrorMovie;

/**
 * Интерфейс StudioFactory, определяющий структуру классов "Studio"
 * Все студии должны снимать Боевики, Комедии и Ужасы
 *
 * @version 1.0
 * @autor Жмайло Василий
 * @since 09.04.2021
 */
public interface StudioFactory {
    void CreationReport();

    ActionMovie createActionMovie();

    Comedy createComedy();

    HorrorMovie createHorrorMovie();
}
