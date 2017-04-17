package numbers;

import exceptions.InvalidNumberException;

public class NumberConversor {

    public String convert(Integer number) throws Exception{
        validNumberBetween0and3000(number);
            return this.miles(number) + this.cents(number) + this.decens(number) + units(number);
        }

    private void validNumberBetween0and3000(Integer number) throws Exception{
        if (number <= 0 || number >= 3000){
            throw new InvalidNumberException("The number must be positive and minor to 3001");
        }
    }

    public String miles(Integer number) {
        String Miles[] = {"", "M", "MM", "MMM"};
        return Miles[number / 1000];
    }
    public String cents(Integer number) {
        String Cents[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        Integer rest = number % 1000;
        return Cents[rest / 100];
    }
    public String decens(Integer number) {
        String Decens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        Integer rest = (number % 100);
        return Decens[rest / 10];
    }
    public String units(Integer number) {
        String Units[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return Units[number % 10];
    }
}
