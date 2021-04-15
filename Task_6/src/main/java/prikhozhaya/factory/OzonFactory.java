package prikhozhaya.factory;

import prikhozhaya.model.chair.Chair;
import prikhozhaya.model.chair.ChairOzon;
import prikhozhaya.model.cupboard.Cupboard;
import prikhozhaya.model.cupboard.CupboardOzon;
import prikhozhaya.model.table.Table;
import prikhozhaya.model.table.TableOzon;

public class OzonFactory implements Factory {

    /*
     *Создает новый объект класса ChairOzon
     */
    @Override
    public Chair createChair() {
        return new ChairOzon();
    }

    /*
     *Создает новый объект класса CupboardOzon
     */
    @Override
    public Cupboard createCupboard() {
        return new CupboardOzon();
    }

    /*
     *Создает новый объект класса TableOzon
     */
    @Override
    public Table createTable() {
        return new TableOzon();
    }
}
