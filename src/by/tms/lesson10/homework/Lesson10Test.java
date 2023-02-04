package by.tms.lesson10.homework;

import by.tms.lesson10.homework.utils.StringUtils;

import java.util.Scanner;

public class Lesson10Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("*********** MENU *************");
            System.out.println("1. Task_1");
            System.out.println("2. Task_2");
            System.out.println("3. Task_3");
            System.out.println("4. Task_4");
            System.out.println("5. Task_5");
            System.out.println("6. Task_6");
            System.out.println("0. Exit");
            System.out.println("******************************");
            System.out.print("Input task number (0 for exit): ");

            int key = scanner.nextInt();
            Scanner sc = new Scanner(System.in);

            switch (key) {
                case 1 -> {
                    System.out.print("Input string: ");
                    String inputString = sc.nextLine();
                    System.out.print("Result: ");
                    System.out.println(StringUtils.getStringWithoutSpareSpaces(inputString));
                }
                case 2 -> {
                    System.out.print("Input card number (16 digit necessary!): ");
                    String inputString = sc.nextLine();
                    System.out.print("Result: ");
                    System.out.println(StringUtils.getSecureCardNumber(inputString.trim()));
                }
                case 3 -> {
                    System.out.print("Input name: ");
                    String name = sc.nextLine();
                    System.out.print("Input surname: ");
                    String surname = sc.nextLine();
                    System.out.print("Input patronymic if necessary or press enter: ");
                    String patronymic = sc.nextLine();
                    System.out.println(StringUtils.getSignature(name.trim(), surname.trim(), patronymic.trim()));
                }
                case 4 -> {
                    System.out.print("Input passport number: ");
                    String number = sc.nextLine();
                    System.out.println("Are input number [" + number + "] a Belarusian passport? ->"
                            + StringUtils.isBelarusPassport(number.trim()));
                }
                case 5 -> {
                    System.out.print("Input preferred password: ");
                    String password = sc.nextLine();
                    System.out.println("Are this password [" + password + "] is strong? -> "
                            + StringUtils.isStrongPassword(password.trim()));
                }
                case 6 -> {
                    System.out.print("Input email address: ");
                    String email = sc.nextLine();
                    System.out.println("Are input string [" + email.trim() + "] is email? -> "
                            + StringUtils.isEmail(email.trim()));
                }
                case 0 -> {
                    System.out.println("See you!!!");
                    return;
                }
                default -> System.out.println("Wrong key!!!");
            }
        } while (true);
    }
}
