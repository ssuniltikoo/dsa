package dev.dp.cdp.factory.flutterfactory;

import dev.dp.cdp.factory.flutterfactory.components.buttons.Button;
import dev.dp.cdp.factory.flutterfactory.components.menu.Menu;

public interface UIFactory {
    Button createButton();
    Menu createMenu();
}
