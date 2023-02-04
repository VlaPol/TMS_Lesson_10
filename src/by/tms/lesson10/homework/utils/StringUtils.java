package by.tms.lesson10.homework.utils;

public class StringUtils {

    public static String getStringWithoutSpareSpaces(String inputString) {

        if (inputString.length() == 0) return inputString;

        String tmpString = inputString.trim();
        if (tmpString.length() == 0) {
            return tmpString;
        } else {
            char[] stringToCharArray = tmpString.toCharArray();

            int elementsCounterForNewString = 1;

            for (int i = 1; i < stringToCharArray.length; i++) {
                if (!(stringToCharArray[i - 1] == ' ' && stringToCharArray[i] == ' ')) {
                    stringToCharArray[elementsCounterForNewString++] = stringToCharArray[i];
                }
            }
            return new String(stringToCharArray, 0, elementsCounterForNewString);
        }
    }

    public static String getSecureCardNumber(String inputString) {

        if (inputString.length() != 16) {
            throw new IllegalArgumentException("Bad card number!");
        }

        char[] stringArrayToChar = inputString.toCharArray();
        char[] secureCardNumber = new char[stringArrayToChar.length + 3];

        int numberCounter = 1;
        int meaningNumbers = 4;

        for (int i = 0; i < secureCardNumber.length; i++) {
            if (numberCounter % 5 == 0) {
                secureCardNumber[i] = ' ';
            } else {
                if (i < secureCardNumber.length - 4) {
                    secureCardNumber[i] = '*';
                } else {
                    secureCardNumber[i] = stringArrayToChar[stringArrayToChar.length - meaningNumbers];
                    meaningNumbers--;
                }
            }
            numberCounter++;
        }
        return new String(secureCardNumber);
    }

    public static String getSignature(String surname, String name, String patronymic) {

        if (surname.length() == 0 || name.length() == 0) {
            throw new IllegalArgumentException("Surname and name are required!");
        }

        String nameAndSurname = getPreparedString(surname) + ' ' + getPreparedString(name).charAt(0) + ".";

        if (patronymic.length() != 0) {
            return nameAndSurname + ' ' + getPreparedString(patronymic).charAt(0) + '.';
        }
        return nameAndSurname;
    }

    public static boolean isBelarusPassport(String inputString) {

        if (inputString.length() != 9) {
            return false;
        }

        char[] stringToCharArray = inputString.toCharArray();

        if (!isUpperAndLatin(stringToCharArray[0]) || !isUpperAndLatin(stringToCharArray[1])) {
            return false;
        }

        for (int i = 2; i < stringToCharArray.length; i++) {
            if (!Character.isDigit(stringToCharArray[i])) {
                return false;
            }
        }

        return true;
    }

    public static boolean isStrongPassword(String inputString) {

        if (inputString.length() < 8) {
            return false;
        }

        char[] stringToChar = inputString.toCharArray();

        boolean hasDigit = false;
        boolean hasUpperLetter = false;
        boolean hasLowerLetter = false;

        for (char c : stringToChar) {
            if (isLatinOrCyrillicUpperCase(c)) hasUpperLetter = true;
            if (isLatinOrCyrillicLowerCase(c)) hasLowerLetter = true;
            if (Character.isDigit(c)) hasDigit = true;

            if (hasDigit && hasLowerLetter && hasUpperLetter) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmail(String inputString) {

        if (inputString.contains("@") && (inputString.indexOf('@') == inputString.lastIndexOf('@'))
                && !inputString.contains(" ")) {
            return inputString.indexOf('@') < inputString.length() - 1 && inputString.indexOf('@') > 0;
        }
        return false;
    }

    private static String getPreparedString(String inputString) {

        String tmpString = getStringWithoutSpareSpaces(inputString);
        char[] stringToCharArray = tmpString.toCharArray();

        if (Character.isLowerCase(stringToCharArray[0])) {
            stringToCharArray[0] = Character.toUpperCase(stringToCharArray[0]);
            return new String(stringToCharArray);
        }
        return new String(stringToCharArray);
    }

    private static boolean isUpperAndLatin(char inputChar) {

        return Character.isUpperCase(inputChar) && ((inputChar >= 'A' && inputChar <= 'Z') ||
                (inputChar >= 'a' && inputChar <= 'z'));
    }

    private static boolean isLatinOrCyrillicUpperCase(char inputChar) {

        return ((inputChar >= 'A' && inputChar <= 'Z') || (inputChar >= 'А' && inputChar <= 'Я')
                || inputChar == 'Ё');
    }

    private static boolean isLatinOrCyrillicLowerCase(char inputChar) {

        return ((inputChar >= 'a' && inputChar <= 'z') || (inputChar >= 'а' && inputChar <= 'я')
                || inputChar == 'ё');
    }

}
