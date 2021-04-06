package lesnoy.factory;

import lesnoy.model.AsusDesktop;
import lesnoy.model.AsusNotebook;
import lesnoy.model.Desktop;
import lesnoy.model.Notebook;

public class AsusFactory implements ComputersFactory {

    @Override
    public Notebook createNotebook() {
        return new AsusNotebook();
    }

    @Override
    public Desktop createDesktop() {
        return new AsusDesktop();
    }
}
