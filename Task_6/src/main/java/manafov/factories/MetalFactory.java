package manafov.factories;

import manafov.bass.Bass;
import manafov.bass.MetalBass;
import manafov.drums.Drums;
import manafov.drums.MetalDrums;
import manafov.lead.Lead;
import manafov.lead.MetalLead;
import manafov.rhythm.MetalRhythm;
import manafov.rhythm.Rhythm;
import manafov.vocals.MetalVocals;
import manafov.vocals.Vocals;

public class MetalFactory implements TracksFactory {
    @Override
    public Drums createDrums() {
        return new MetalDrums();
    }

    @Override
    public Bass createBass() {
        return new MetalBass();
    }

    @Override
    public Rhythm createRhythm() {
        return new MetalRhythm();
    }

    @Override
    public Vocals createVocals() {
        return new MetalVocals();
    }

    @Override
    public Lead createLead() {
        return new MetalLead();
    }
}
