package converter;

import javafx.util.StringConverter;

public class NumberSystemConverter extends StringConverter<String> {

    private int fromRadix;
    private int toRadix;

    public NumberSystemConverter(int fromRadix, int toRadix) {
        this.fromRadix = fromRadix;
        this.toRadix = toRadix;
    }

    @Override
    public String toString(String s) {
        return Integer.toString(Integer.parseInt(s, toRadix), fromRadix);
    }

    @Override
    public String fromString(String s) {
        return Integer.toString(Integer.parseInt(s, fromRadix), toRadix);
    }

}
