package lesnoy.factory;

import lesnoy.model.Desktop;
import lesnoy.model.Notebook;

public interface ComputersFactory {
    Notebook createNotebook();
    Desktop createDesktop();
}
