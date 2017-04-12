package numbers;

import org.apache.commons.lang3.StringUtils;

public class NumberConversor {

    public String convert(Integer number) {

        if (number >= 1 && number <= 3)
            return this.replicateString("I", number);
        if (number == 4)
            return "IV";
        if (number > 4)
            return "V" + StringUtils.repeat("I", number - 5);
        switch (number) {
            case 10:
                return "X";
            case 50:
                return "L";
            case 100:
                return "C";
            case 500:
                return "D";
            case 1000:
                return "M";
            default:
                return " ";
        }
    }

    private String replicateString(String letraARepetir, Integer multiplicador) {
        String cadena = "";
        for (int i = 0; i < multiplicador; i++) {
            cadena = cadena + letraARepetir;
        }
        return cadena;
    }
}