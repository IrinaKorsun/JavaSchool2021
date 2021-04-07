package manafov.factories;

import manafov.bass.Bass;
import manafov.drums.Drums;
import manafov.lead.Lead;
import manafov.rhythm.Rhythm;
import manafov.vocals.Vocals;

public interface TracksFactory {
    Drums createDrums();

    Bass createBass();

    Rhythm createRhythm();

    Vocals createVocals();

    Lead createLead();
}
