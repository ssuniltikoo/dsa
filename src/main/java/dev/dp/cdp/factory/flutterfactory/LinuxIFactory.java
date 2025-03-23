package dev.dp.cdp.factory.flutterfactory;

import dev.dp.cdp.factory.flutterfactory.components.buttons.Button;
import dev.dp.cdp.factory.flutterfactory.components.buttons.LinuxButton;
import dev.dp.cdp.factory.flutterfactory.components.menu.LinuxMenu;
import dev.dp.cdp.factory.flutterfactory.components.menu.Menu;

public class LinuxIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public Menu createMenu() {
        return new LinuxMenu();
    }
}
