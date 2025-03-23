package dev.dp.cdp.factory.flutterfactory;


public class Client {
    public static void main(String[] args) {
        Flutter flutter = new Flutter();
        flutter.setPort(8080);
        flutter.setRefreshRate(10000);
        flutter.refreshUI();
        UIFactory factory  = flutter.getUIFactory(Platform.MACOS);
        factory.createButton().displayButton();
        factory.createMenu().displayMenu();

    }
}
