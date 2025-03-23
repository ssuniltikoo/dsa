package dev.dp.cdp.prototype.configuration;

public class Configuration implements Configurable<Configuration>{



    private int configId;
    private String configName;
    private String configValue;

    public void setConfigId(int configId) {
        this.configId = configId;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    private String themeColor;
    private Boolean autoSave;
    private String language;
    private Boolean darkMode;
    private Integer fontSize;
    private String fontFamily;
    private ConfigurationType type;
    private boolean isEnabled;

    public int getConfigId() {
        return configId;
    }
    public String getConfigName() {
        return configName;
    }

    public String getConfigValue() {
        return configValue;
    }

    public boolean isEnabled() {
        return isEnabled;
    }



    @Override
    public Configuration cloneObject() {
        Configuration protoTypeObject = new Configuration(
                this.themeColor,this.autoSave,this.language,this.darkMode,this.fontSize,this.fontFamily,this.type
        );


        return protoTypeObject;
    }



    public Configuration(String themeColor, Boolean autoSave, String language, Boolean darkMode, Integer fontSize, String fontFamily, ConfigurationType type) {
        this.themeColor = themeColor;
        this.autoSave = autoSave;
        this.language = language;
        this.darkMode = darkMode;
        this.fontSize = fontSize;
        this.fontFamily = fontFamily;
        this.type = type;
    }

    public String getThemeColor() {
        return themeColor;
    }

    public Boolean getAutoSave() {
        return autoSave;
    }

    public String getLanguage() {
        return language;
    }

    public Boolean getDarkMode() {
        return darkMode;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public ConfigurationType getType() {
        return type;
    }
}
