package utilities;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class utilities {
    static NumberFormat numberFormat =
            new DecimalFormat("R$ #,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

    public static String doubleToString(Double value) {
        return numberFormat.format(value);
    }
}
