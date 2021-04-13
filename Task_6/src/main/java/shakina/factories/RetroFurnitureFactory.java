package shakina.factories;

import shakina.furniture.bed.Bed;
import shakina.furniture.bed.RetroBed;
import shakina.furniture.chair.Chair;
import shakina.furniture.chair.RetroChair;
import shakina.furniture.couch.Couch;
import shakina.furniture.couch.RetroCouch;
import shakina.furniture.table.RetroTable;
import shakina.furniture.table.Table;
import shakina.furniture.wardrobe.RetroWardrobe;
import shakina.furniture.wardrobe.Wardrobe;

public class RetroFurnitureFactory implements FurnitureFactory {
    @Override
    public Bed makeBed() {
        return new RetroBed();
    }

    @Override
    public Chair makeChair() {
        return new RetroChair();
    }

    @Override
    public Couch makeCouch() {
        return new RetroCouch();
    }

    @Override
    public Table makeTable() {
        return new RetroTable();
    }

    @Override
    public Wardrobe makeWardrobe() {
        return new RetroWardrobe();
    }
}
