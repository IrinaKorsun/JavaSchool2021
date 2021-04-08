package manafov.factories;

import manafov.bass.Bass;
import manafov.bass.EdmBass;
import manafov.drums.Drums;
import manafov.drums.EdmDrums;
import manafov.lead.EdmLead;
import manafov.lead.Lead;
import manafov.rhythm.EdmRhythm;
import manafov.rhythm.Rhythm;
import manafov.vocals.EdmVocals;
import manafov.vocals.Vocals;

public class EdmFactory implements TracksFactory {
    @Override
    public Drums createDrums() {
        return new EdmDrums();
    }

    @Override
    public Bass createBass() {
        return new EdmBass();
    }

    @Override
    public Rhythm createRhythm() {
        return new EdmRhythm();
    }

    @Override
    public Vocals createVocals() {
        return new EdmVocals();
    }

    @Override
    public Lead createLead() {
        return new EdmLead();
    }
}
