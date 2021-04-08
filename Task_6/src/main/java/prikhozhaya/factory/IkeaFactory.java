package prikhozhaya.factory;

import prikhozhaya.model.chair.Chair;
import prikhozhaya.model.chair.ChairIkea;
import prikhozhaya.model.cupboard.Cupboard;
import prikhozhaya.model.cupboard.CupboardIkea;
import prikhozhaya.model.table.Table;
import prikhozhaya.model.table.TableIkea;

public class IkeaFactory implements Factory {

    /*
    *Создает новый объект класса ChairIkea
     */
    @Override
    public Chair createChair() {
        return new ChairIkea();
    }

    /*
     *Создает новый объект класса CupboardIkea
     */
    @Override
    public Cupboard createCupboard() {
        return new CupboardIkea();
    }

    /*
     *Создает новый объект класса TableIkea
     */
    @Override
    public Table createTable() {
        return new TableIkea();
    }
}
