package dev.dp.cdp.factory.flutterfactory;

import dev.dp.cdp.factory.flutterfactory.components.buttons.Button;
import dev.dp.cdp.factory.flutterfactory.components.buttons.WindowsButton;
import dev.dp.cdp.factory.flutterfactory.components.menu.Menu;
import dev.dp.cdp.factory.flutterfactory.components.menu.WindowsMenu;

public class WindowsUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Menu createMenu() {
        return new WindowsMenu();
    }
}
