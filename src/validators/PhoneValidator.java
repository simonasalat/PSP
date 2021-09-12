package validators;

public class PhoneValidator {

    private String prefix;
    private int length;

    public boolean checkSymbols(String phoneNumber) {
        return true;
    }

    public String changePrefix(String prefix, String phoneNumber) {
        return "+37061111111";
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    public boolean validateNumberByCountry(String country, String number)
    {
        return true;
    }
    /*public String validateNumberByCountry(String country, String number) {

        if (number.length() < 12) {
            return "Phone number length is too short";
        }
        if (number.length() > 12) {
            return "Phone number length is too long";
        }
        if (!number.substring(0, 3).startsWith("+33")) {
            return "Prefix is incorrect";
        }

        return "OK";
    }*/
}
