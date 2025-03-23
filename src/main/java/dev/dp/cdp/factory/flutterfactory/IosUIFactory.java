package dev.dp.cdp.factory.flutterfactory;

import dev.dp.cdp.factory.flutterfactory.components.buttons.Button;
import dev.dp.cdp.factory.flutterfactory.components.buttons.IosButton;
import dev.dp.cdp.factory.flutterfactory.components.menu.IosMenu;
import dev.dp.cdp.factory.flutterfactory.components.menu.Menu;

public class IosUIFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new IosButton();
    }

    @Override
    public Menu createMenu() {
        return new IosMenu();
    }
}
