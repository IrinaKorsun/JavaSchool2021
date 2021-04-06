package lesnoy.factory;

import lesnoy.model.Desktop;
import lesnoy.model.Notebook;
import lesnoy.model.DellDesktop;
import lesnoy.model.DellNotebook;

public class DellFactory implements ComputersFactory {
    @Override
    public Notebook createNotebook() {
        return new DellNotebook();
    }

    @Override
    public Desktop createDesktop() {
        return new DellDesktop();
    }
}
