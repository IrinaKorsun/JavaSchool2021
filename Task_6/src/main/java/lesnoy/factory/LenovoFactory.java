package lesnoy.factory;

import lesnoy.model.Desktop;
import lesnoy.model.Notebook;
import lesnoy.model.LenovoDesktop;
import lesnoy.model.LenovoNotebook;

public class LenovoFactory implements ComputersFactory {
    @Override
    public Notebook createNotebook() {
        return new LenovoNotebook();
    }

    @Override
    public Desktop createDesktop() {
        return new LenovoDesktop();
    }
}
