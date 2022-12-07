package Main;

import Account.ManageAccount;
import ManageDictionary.Dictionary;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ManageAccount manageAccount = new ManageAccount();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("┌——————— MENU ———————┐");
            System.out.println("⎟    1.Đăng nhập     ⎟ ");
            System.out.println("⎟    2.Đăng ký       ⎟");
            System.out.println("⎟    3.Đổi mật khẩu  ⎟");
            System.out.println("⎟    4.Thoát         ⎟");
            System.out.println("└————————————————————┘");
            System.out.println("Nhập lựa chọn số: ");
            int choice = 0;
            do {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice <= 0 | choice >= 5) {
                        System.out.println("Nhập lựa chọn từ 1 tới 4");
                    } else {
                        break;
                    }
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Chỉ nhập số!");
                }
            } while (true);

            switch (choice) {
                case 1:
                    manageAccount.logIn();
                    break;
                case 2:
                    manageAccount.register();
                    break;
                case 3:
                    manageAccount.changePassword();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void menuDictionary() {
        Scanner scanner = new Scanner(System.in);
        Dictionary dictionary = new Dictionary();

        while (true) {
            int choice;
            System.out.println("┌——————— DICTIONARY ————————┐");
            System.out.println("⎟   1. Thêm từ vựng         ⎟");
            System.out.println("⎟   2. Tra từ vựng          ⎟");
            System.out.println("⎟   3. Bổ sung định nghĩa   ⎟");
            System.out.println("⎟   4. Xóa một mục từ       ⎟");
            System.out.println("⎟   5. Hiển thị từ điển     ⎟");
            System.out.println("⎟   6. Đăng xuất            ⎟");
            System.out.println("└———————————————————————————┘");
            System.out.println("Nhập lựa chọn số: ");
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice <= 0 | choice >= 7) {
                        System.out.println("Nhập lựa chọn từ 1 tới 6");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Chỉ nhập số");
                }
            }

            switch (choice) {
                case 1:
                    dictionary.addWord();
                    break;
                case 2:
                    dictionary.lookUp();
                    break;
                case 3:
                    dictionary.addDefinition();
                    break;
                case 4:
                    dictionary.deleteWord();
                    break;
                case 5:
                    dictionary.display();
                    break;
                case 6:
                    return;
            }
        }
    }
}
