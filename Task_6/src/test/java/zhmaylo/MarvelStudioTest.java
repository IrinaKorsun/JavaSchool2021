package zhmaylo;

import org.junit.jupiter.api.Test;
import zhmaylo.Studios.MarvelMovies.MarvelActionMovie;
import zhmaylo.Studios.MarvelMovies.MarvelComedy;
import zhmaylo.Studios.MarvelMovies.MarvelHorrorMovie;
import zhmaylo.Studios.MarvelStudio;

import static org.junit.jupiter.api.Assertions.*;

class MarvelStudioTest {

    @Test
    void checkCreationReport() {
        StudioFactory studio = new MarvelStudio();
        studio.CreationReport();
        assertEquals("MarvelStudio", studio.getClass().getSimpleName());
    }

    @Test
    void CheckActionMovieCreation() {
        MarvelActionMovie movie = new MarvelActionMovie();
        assertEquals("MarvelActionMovie", movie.getClass().getSimpleName());
    }

    @Test
    void CheckComedyCreation() {
        MarvelComedy movie = new MarvelComedy();
        assertEquals("MarvelComedy", movie.getClass().getSimpleName());
    }

    @Test
    void CheckHorrorMovieCreation() {
        MarvelHorrorMovie movie = new MarvelHorrorMovie();
        assertEquals("MarvelHorrorMovie", movie.getClass().getSimpleName());
    }
}