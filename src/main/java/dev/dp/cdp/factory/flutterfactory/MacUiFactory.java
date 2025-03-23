package dev.dp.cdp.factory.flutterfactory;

import dev.dp.cdp.factory.flutterfactory.components.buttons.Button;
import dev.dp.cdp.factory.flutterfactory.components.buttons.MacBuuton;
import dev.dp.cdp.factory.flutterfactory.components.menu.MacMenu;
import dev.dp.cdp.factory.flutterfactory.components.menu.Menu;

public class MacUiFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new MacBuuton();
    }

    @Override
    public Menu createMenu() {
        return new MacMenu();
    }
}
