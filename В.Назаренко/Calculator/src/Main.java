import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataReader reader = new DataReader();
        while (true) {
            try {
                reader.read();
            }
            catch (RuntimeException ex) {
                throw ex;
            }
            int result = Calculator.calculate(reader.getVar1(), reader.getVar2(), reader.getOper());
            System.out.println("Output");
            if(reader.isRoman()){
                System.out.println(DataReader.numberToRoman(result));
            }
            else {
                System.out.println(result);
            }
        }
    }
}
class DataReader {
    private int number1;
    private int number2;
    private char operation;
    private boolean isRoman;

    public void read() {
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        System.out.println("Input");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        try {
            text = text.substring(0, text.length());
            String[] blocks = text.split("[+-/*]");
            boolean flag = false;
            for (int i = 0; i < roman.length; i++){
                if (roman[i].equals(blocks[0]) || roman[i].equals(blocks[1])) {
                    flag = true;
                }
            }
            this.isRoman = flag;
            if(flag){
                number1 = romanToNumber(blocks[0]);
                number2 = romanToNumber(blocks[1]);
                operation = text.charAt(blocks[0].length());
            }
            else {
                number1 = Integer.parseInt(blocks[0]);
                number2 = Integer.parseInt(blocks[1]);
                operation = text.charAt(blocks[0].length());
            }
            if ((number1 > 10 || number1 < 0) || (number2 > 10 || number2 < 0)) {
                throw new IllegalArgumentException();
            }
        }
        catch (RuntimeException e) {
            throw new IllegalArgumentException("Invalid data");
        }
    }
    public static int romanToNumber(String val) {
        if (val.equals("I")) {
            return 1;
        }
        else if (val.equals("II")) {
            return 2;
        }
        else if (val.equals("III")) {
            return 3;
        }
        else if (val.equals("IV")) {
            return 4;
        }
        else if (val.equals("V")) {
            return 5;
        }
        else if (val.equals("VI")) {
            return 6;
        }
        else if (val.equals("VII")) {
            return 7;
        }
        else if (val.equals("VIII")) {
            return 8;
        }
        else if (val.equals("IX")) {
            return 9;
        }
        else if (val.equals("X")) {
            return 10;
        }
        else {
            return -1;
        }
    }
    public static String numberToRoman(int val) {
        if (val < 1 || val > 3999)
            return "Invalid Roman Number Value";
        String s = "";
        while (val >= 1000) {
            s += "M";
            val -= 1000;
        }
        while (val >= 900) {
            s += "CM";
            val -= 900;
        }
        while (val >= 500) {
            s += "D";
            val -= 500;
        }
        while (val >= 400) {
            s += "CD";
            val -= 400;
        }
        while (val >= 100) {
            s += "C";
            val -= 100;
        }
        while (val >= 90) {
            s += "XC";
            val -= 90;
        }
        while (val >= 50) {
            s += "L";
            val -= 50;
        }
        while (val >= 40) {
            s += "XL";
            val -= 40;
        }
        while (val >= 10) {
            s += "X";
            val -= 10;
        }
        while (val >= 9) {
            s += "IX";
            val -= 9;
        }
        while (val >= 5) {
            s += "V";
            val -= 5;
        }
        while (val >= 4) {
            s += "IV";
            val -= 4;
        }
        while (val >= 1) {
            s += "I";
            val -= 1;
        }
        return s;
    }
    public int getVar1() { return this.number1; }
    public int getVar2() { return this.number2; }
    public char getOper() { return this.operation; }
    public boolean isRoman() { return this.isRoman; }
}
class Calculator {
    public static int calculate(int number1, int number2, char operation) {
        int result = 0;
        switch (operation) {
            case '+': result = number1 + number2; break;
            case '-': result = number1 - number2; break;
            case '*': result = number1 * number2; break;
            case '/': result = number1 / number2; break;
            default:throw new IllegalArgumentException("Invalid operation");
        }
        return result;
    }
}