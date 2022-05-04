package NoWarPolis;

import java.util.ArrayList;

public class Tags {

    private String key;
    private String value;
    private ArrayList<String> arrayValues;

    public Tags(String key, String value){
        setKey(key);
        setValue(value);
    }

    public Tags(String key, ArrayList<String> arrayValues){
        setKey(key);
        setArrayValues(arrayValues);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArrayList<String> getArrayValues() {
        return arrayValues;
    }

    public void setArrayValues(ArrayList<String> arrayValues) {
        this.arrayValues = arrayValues;
    }

}