package shakina.factories;

import shakina.furniture.bed.Bed;
import shakina.furniture.bed.ModernBed;
import shakina.furniture.chair.Chair;
import shakina.furniture.chair.ModernChair;
import shakina.furniture.couch.Couch;
import shakina.furniture.couch.ModernCouch;
import shakina.furniture.table.ModernTable;
import shakina.furniture.table.Table;
import shakina.furniture.wardrobe.ModernWardrobe;
import shakina.furniture.wardrobe.Wardrobe;

public class ModernFurnitureFactory implements FurnitureFactory {

    @Override
    public Bed makeBed() {
        return new ModernBed();
    }

    @Override
    public Chair makeChair() {
        return new ModernChair();
    }

    @Override
    public Couch makeCouch() {
        return new ModernCouch();
    }

    @Override
    public Table makeTable() {
        return new ModernTable();
    }

    @Override
    public Wardrobe makeWardrobe() {
        return new ModernWardrobe();
    }
}
