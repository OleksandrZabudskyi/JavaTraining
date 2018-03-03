package ua.tasks.task1;

public class Model {
    private String stringValue;

    public Model() {
        this.stringValue = "";
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public String addStringValue(String string) {
        return stringValue += " " + string;
    }
}
