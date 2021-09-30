package main.java.lt.vu.biblioteka.validator;

public class PasswordChecker {

    private int minLength = 5;
    private char[] specialSymbols = new char[]{'@', '#', '$','!', '%', '&', '*', '+', '-', '/', '=', '?', '^', '_', '`', '{', '|'};

    public boolean isPasswordValid(String password) {

        if (password == null) {
            return false;
        }
        return checkPasswordLength(password) && checkUppercase(password) && checkSpecialSymbols(password);
    }

    private boolean checkPasswordLength(String password) {

        return password.length() >= minLength;
    }

    private boolean checkUppercase(String password) {

        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean checkSpecialSymbols(String password) {

        for (int i = 0; i < password.length(); i++) {
            for (char specialSymbol : specialSymbols) {
                if (password.charAt(i) == specialSymbol) {
                    return true;
                }
            }
        }
        return false;
    }

}
