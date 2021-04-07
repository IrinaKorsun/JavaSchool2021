package manafov.factories;

import manafov.bass.Bass;
import manafov.bass.PopBass;
import manafov.drums.Drums;
import manafov.drums.PopDrums;
import manafov.lead.Lead;
import manafov.lead.PopLead;
import manafov.rhythm.PopRhythm;
import manafov.rhythm.Rhythm;
import manafov.vocals.PopVocals;
import manafov.vocals.Vocals;

public class PopFactory implements TracksFactory {
    @Override
    public Drums createDrums() {
        return new PopDrums();
    }

    @Override
    public Bass createBass() {
        return new PopBass();
    }

    @Override
    public Rhythm createRhythm() {
        return new PopRhythm();
    }

    @Override
    public Vocals createVocals() {
        return new PopVocals();
    }

    @Override
    public Lead createLead() {
        return new PopLead();
    }
}
