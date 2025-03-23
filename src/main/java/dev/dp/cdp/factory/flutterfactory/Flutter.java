package dev.dp.cdp.factory.flutterfactory;

public class Flutter {
    private int port;
    private int refreshRate;

    public void setPort(int port) {
        this.port = port;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public void refreshUI(){
        System.out.println("UI refresh");
    }

    // factory method to get the object of corresponding UIfactory

    public  UIFactory getUIFactory(Platform platform) {
        return UiFactoryFactory.getUIFactory(platform);
    }



}
