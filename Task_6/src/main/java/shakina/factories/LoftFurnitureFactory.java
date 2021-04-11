package shakina.factories;

import shakina.furniture.bed.Bed;
import shakina.furniture.bed.LoftBed;
import shakina.furniture.chair.Chair;
import shakina.furniture.chair.LoftChair;
import shakina.furniture.couch.Couch;
import shakina.furniture.couch.LoftCouch;
import shakina.furniture.table.LoftTable;
import shakina.furniture.table.Table;
import shakina.furniture.wardrobe.LoftWardrobe;
import shakina.furniture.wardrobe.Wardrobe;

public class LoftFurnitureFactory implements FurnitureFactory {
    @Override
    public Bed makeBed() {
        return new LoftBed();
    }

    @Override
    public Chair makeChair() {
        return new LoftChair();
    }

    @Override
    public Couch makeCouch() {
        return new LoftCouch();
    }

    @Override
    public Table makeTable() {
        return new LoftTable();
    }

    @Override
    public Wardrobe makeWardrobe() {
        return new LoftWardrobe();
    }
}
