package dev.dp.cdp.factory.flutterfactory;

public class UiFactoryFactory {

    public static UIFactory getUIFactory(Platform platform){
        if(platform == Platform.ANDROID){
            return new AndroidUIFactory();
        }
        if (platform == Platform.IOS){
            return new IosUIFactory();
        }
        if (platform == Platform.WINDOWS){
            return new WindowsUIFactory();
        }

        if (platform == Platform.MACOS){
            return new MacUiFactory();
        }
        if (platform == Platform.LINUX){
            return new LinuxIFactory();
        }
        throw new IllegalArgumentException("Unsupported platform: " + platform);
    }
}
