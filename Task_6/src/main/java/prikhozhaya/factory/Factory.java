package prikhozhaya.factory;

import prikhozhaya.model.chair.Chair;
import prikhozhaya.model.cupboard.Cupboard;
import prikhozhaya.model.table.Table;

public interface Factory {
     Chair createChair();
     Cupboard createCupboard();
     Table createTable();
}
