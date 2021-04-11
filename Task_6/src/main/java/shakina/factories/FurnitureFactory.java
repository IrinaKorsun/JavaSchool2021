package shakina.factories;

import shakina.furniture.bed.Bed;
import shakina.furniture.chair.Chair;
import shakina.furniture.couch.Couch;
import shakina.furniture.table.Table;
import shakina.furniture.wardrobe.Wardrobe;

public interface FurnitureFactory {
    Bed makeBed();

    Chair makeChair();

    Couch makeCouch();

    Table makeTable();

    Wardrobe makeWardrobe();
}