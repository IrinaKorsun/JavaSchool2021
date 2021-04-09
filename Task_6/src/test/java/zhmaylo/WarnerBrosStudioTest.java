package zhmaylo;

import org.junit.jupiter.api.Test;
import zhmaylo.Studios.WarnerBrosMovies.WarnerBrosActionMovie;
import zhmaylo.Studios.WarnerBrosMovies.WarnerBrosComedy;
import zhmaylo.Studios.WarnerBrosMovies.WarnerBrosHorrorMovie;
import zhmaylo.Studios.WarnerBrosStudio;

import static org.junit.jupiter.api.Assertions.*;

class WarnerBrosStudioTest {

    @Test
    void checkCreationReport() {
        StudioFactory studio = new WarnerBrosStudio();
        studio.CreationReport();
        assertEquals("WarnerBrosStudio", studio.getClass().getSimpleName());
    }

    @Test
    void CheckActionMovieCreation() {
        WarnerBrosActionMovie movie = new WarnerBrosActionMovie();
        assertEquals("WarnerBrosActionMovie", movie.getClass().getSimpleName());
    }

    @Test
    void CheckComedyCreation() {
        WarnerBrosComedy movie = new WarnerBrosComedy();
        assertEquals("WarnerBrosComedy", movie.getClass().getSimpleName());
    }

    @Test
    void CheckHorrorMovieCreation() {
        WarnerBrosHorrorMovie movie = new WarnerBrosHorrorMovie();
        assertEquals("WarnerBrosHorrorMovie", movie.getClass().getSimpleName());
    }
}