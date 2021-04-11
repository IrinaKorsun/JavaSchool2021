package shakina.factories;

import shakina.furniture.bed.Bed;
import shakina.furniture.bed.ClassicBed;
import shakina.furniture.chair.Chair;
import shakina.furniture.chair.ClassicChair;
import shakina.furniture.couch.ClassicCouch;
import shakina.furniture.couch.Couch;
import shakina.furniture.table.ClassicTable;
import shakina.furniture.table.Table;
import shakina.furniture.wardrobe.ClassicWardrobe;
import shakina.furniture.wardrobe.Wardrobe;

public class ClassicFurnitureFactory implements FurnitureFactory {
    @Override
    public Bed makeBed() {
        return new ClassicBed();
    }

    @Override
    public Chair makeChair() {
        return new ClassicChair();
    }

    @Override
    public Couch makeCouch() {
        return new ClassicCouch();
    }

    @Override
    public Table makeTable() {
        return new ClassicTable();
    }

    @Override
    public Wardrobe makeWardrobe() {
        return new ClassicWardrobe();
    }
}
