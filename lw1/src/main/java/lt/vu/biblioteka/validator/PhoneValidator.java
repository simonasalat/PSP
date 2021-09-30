package main.java.lt.vu.biblioteka.validator;

import main.java.lt.vu.biblioteka.model.Country;

import java.util.List;

public class PhoneValidator {

    List<Country> countryList;
    String phoneNumber;

    public boolean isPhoneValid(String number, List<Country> countryList) {

        if (number == null) {
            return false;
        }

        this.countryList = countryList;
        phoneNumber = changePrefix(number);
        Country country = findCountry(phoneNumber);

        if (country == null) {
            return false;
        }

        return checkLength(phoneNumber.length(), country.getLength()) &&
                checkIfContainsOnlyNumbers(phoneNumber.substring(country.getPrefix().length()));

    }

    private boolean checkIfContainsOnlyNumbers(String phoneNumber) {

        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private Country findCountry(String phoneNumber) {

        String prefix;

        for (Country country : countryList) {

            prefix = country.getPrefix();

            if (phoneNumber.startsWith(prefix)) {
                return country;
            }
        }
        return null;
    }

    private boolean checkLength(int phoneNumber, int length) {

        return phoneNumber == length;
    }

    private String changePrefix(String phoneNumber) {

        if (phoneNumber.startsWith("8")) {
            return phoneNumber.replaceFirst("8", "+370");
        }
        return phoneNumber;
    }


}
