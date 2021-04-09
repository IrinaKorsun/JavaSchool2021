package zhmaylo;

import org.junit.jupiter.api.Test;
import zhmaylo.Studios.UniversalMovies.UniversalActionMovie;
import zhmaylo.Studios.UniversalMovies.UniversalComedy;
import zhmaylo.Studios.UniversalMovies.UniversalHorrorMovie;
import zhmaylo.Studios.UniversalStudio;

import static org.junit.jupiter.api.Assertions.*;

class UniversalStudioTest {

    @Test
    void checkCreationReport() {
        StudioFactory studio = new UniversalStudio();
        studio.CreationReport();
        assertEquals("UniversalStudio", studio.getClass().getSimpleName());
    }

    @Test
    void CheckActionMovieCreation() {
        UniversalActionMovie movie = new UniversalActionMovie();
        assertEquals("UniversalActionMovie", movie.getClass().getSimpleName());
    }

    @Test
    void CheckComedyCreation() {
        UniversalComedy movie = new UniversalComedy();
        assertEquals("UniversalComedy", movie.getClass().getSimpleName());
    }

    @Test
    void CheckHorrorMovieCreation() {
        UniversalHorrorMovie movie = new UniversalHorrorMovie();
        assertEquals("UniversalHorrorMovie", movie.getClass().getSimpleName());
    }
}