package dev.dp.cdp.factory.flutterfactory;

import dev.dp.cdp.factory.flutterfactory.components.buttons.AndroidButton;
import dev.dp.cdp.factory.flutterfactory.components.buttons.Button;
import dev.dp.cdp.factory.flutterfactory.components.menu.AndroidMenu;
import dev.dp.cdp.factory.flutterfactory.components.menu.Menu;

public class AndroidUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }
}
