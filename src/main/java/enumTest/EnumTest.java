package enumTest;

import java.util.Scanner;

public class EnumTest {
    public static void main(String[] args) {
        UserRole role1 = UserRole.ADMINISTRATOR;
        UserRole role2 = UserRole.EDITOR;
        System.out.println("role1.getClass().getSuperclass() = " + role1.getClass().getSuperclass());
        System.out.println("(role1 == role2) = " + (role1 == role2));
        switch (role1) {
            case ADMINISTRATOR -> System.out.println(" You  can do everything");
            case EDITOR -> System.out.println(" You  can edit records");
            case READER -> System.out.println(" You  can read the records");
        }
        System.out.println("_________________________________");
        String name = role1.name();

        int order = role1.ordinal();

        System.out.println("name = " + name);
        System.out.println("order = " + order);
        System.out.println("_________________________________");

        UserRole role3 = UserRole.valueOf("READER");
        UserRole role4 = UserRole.valueOf(UserRole.class,"EDITOR");
        System.out.println("role3 = " + role3);
        System.out.println("role4 = " + role4);
        System.out.println("_________________________________");

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Input you role : ");
//        String s = sc.nextLine();
//
//        UserRole role5 = UserRole.valueOf(s);
//        switch (role5) {
//            case ADMINISTRATOR -> System.out.println(" You  can do everything");
//            case EDITOR -> System.out.println(" You  can edit records");
//            case READER -> System.out.println(" You  can read the records");
//        }

        UserRole[] values = UserRole.values();
        for (UserRole value : values) {
            System.out.println("value = " + value);
        }
    }

}
