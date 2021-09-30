package main.java.lt.vu.biblioteka.validator;

public class EmailValidator {

    public boolean isEmailValid(String email) {
        if (email == null) {
            return false;
        }
        return checkAtSign(email) && !checkSpecialSymbols(email) && checkDomainAndTLD(email);
    }

    private boolean checkAtSign(String email) {

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                return true;
            }
        }
        return false;
    }

    private String getDomain(String email) {

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                return email.substring(i + 1);
            }
        }
        return null;
    }

    private boolean checkSpecialSymbols(String email) {

        char[] specialSymbols = new char[]{'!', '#', '$', '%', '&', '*', '+', '-', '/', '=', '?', '^', '_', '`', '{', '|'};

        for (int i = 0; i < email.length(); i++) {
            for (char specialSymbol : specialSymbols) {
                if (email.charAt(i) == specialSymbol) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDomainAndTLD(String email) {

        String domain = getDomain(email);

        if (domain == null) {
            return false;
        }
        int index = domain.indexOf(".");

        if (index != -1) {
            return checkDomainLength(domain.substring(0, index)) &&
                    checkTLDLength(domain.substring(index));
        }
        return false;
    }

    private boolean checkDomainLength(String domain) {

        return domain.length() <= 253 && domain.length() >= 1;
    }

    private boolean checkTLDLength(String tld) {

        return tld.length() <= 63 && tld.length() >= 2;
    }
}
