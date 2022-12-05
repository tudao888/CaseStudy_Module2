package Account;

import Main.Main;
import ReadAndWrite.ReadAndWriteAccount;

import java.util.Map;
import java.util.Scanner;

public class ManageAccount {
    Scanner scanner = new Scanner(System.in);
    Map<String, String> manageAcount = (Map<String, String>) ReadAndWriteAccount.readAccount();

    public void register() {

        String password, username;

        while (true) {

            System.out.println("Đăng ký - Nhập tài khoản");
            username = scanner.nextLine();

            if (checkInputUsername(username)) {
                break;
            } else {
                System.err.println("Tài khoản bắt đầu bằng ký tự in hoa, dài từ 6-12 ký tự, và không bao gồm ký tự đặc biệt !@#$%^&*_+-");;
            }
        }

        while (true) {

            System.out.println("Đăng ký - Nhập mật khẩu");
            password = scanner.nextLine();

            if (checkInputPassword(password)) {
                break;
            } else {
                System.err.println("Mật khẩu dài thiểu 6 ký tự");
            }
        }

        manageAcount.put(username, password);
        System.out.println("Đăng ký thành công, mời đăng nhập");
        ReadAndWriteAccount.writeAccount(manageAcount);
    }

    public boolean checkKey(String username) {
        return manageAcount.containsKey(username);
    }

    public void logIn() {

        String password, username;

        int countUsername = 3;

        while (true) {

            System.out.println("Nhập tài khoản: ");
            username = scanner.nextLine();
            System.out.println("Nhập mật khẩu: ");
            password = scanner.nextLine();

            if (checkKey(username)) {

                if (manageAcount.get(username).equals(password)) {

                    System.out.println("Đăng nhập thành công");
                    Main.menuDictionary();
                    return;

                } else {

                    int countPassword = 3;

                    do {
                        countPassword--;
                        System.err.println("Sai mật khẩu, bạn còn " + countPassword + " lần nhập");
                        System.out.println("Nhập mật khẩu: ");
                        password = scanner.nextLine();
                        if (manageAcount.get(username).equals(password)) {
                            System.out.println("Đăng nhập thành công");
                            Main.menuDictionary();
                            return;
                        }
                        if (countPassword == 1) {
                            System.err.println("Bạn đã nhập sai 3 lần, hệ thống tự đóng");
                            return;
                        }

                    } while (true);
                }

            } else {
                countUsername--;
                System.err.println("Tài khoản không tồn tại. " + "Bạn còn " + countUsername + " lần nhập");

                if (countUsername == 0) {
                    System.err.println("Bạn đã nhập sai 3 lần, chuyển sang đăng ký tài khoản");
                    register();
                    return;
                }
            }
        }
    }

    public void changePassword() {

        int countUsername = 3;

        while (true) {

            System.out.println("Nhập tài khoản");
            String username = scanner.nextLine();

            if (checkKey(username)) {

                int countPassword = 3;

                while (true) {

                    System.out.println("Nhập mật khẩu");
                    String password = scanner.nextLine();

                    if (manageAcount.get(username).equals(password)) {
                        String newPassWord;

                        while (true) {

                            System.out.println("Nhập mật khẩu mới");
                            newPassWord = scanner.nextLine();

                            if (checkInputPassword(newPassWord)) {
                                manageAcount.replace(username, password, newPassWord);
                                System.out.println("Đổi mật khẩu thành công, mời đăng nhập");
                                return;
                            } else {
                                System.err.println("Mật khẩu dài tốt thiểu 6 ký tự");
                            }

                        }

                    } else {
                        countPassword--;
                        System.err.println("Sai mật khẩu, bạn còn " + countPassword + " lần nhập lại");

                    }
                    if (countPassword == 0) {
                        System.err.println("Bạn đã nhập sai mật khẩu 3 lần, hệ thống tự đóng!");
                        break;
                    }
                }
                ReadAndWriteAccount.writeAccount(manageAcount);
                break;

            } else {
                countUsername--;
                System.out.println("Tài khoản không tồn lại, hãy thử lại");
                System.out.println("Bạn còn " + countUsername + " lần nhập");
                if (countUsername == 0) {
                    System.out.println("Bạn đã nhập sai tài khoản 3 lần, hệ thống tự đóng");
                    return;
                }
            }
        }
    }

    public boolean checkInputUsername(String username) {

        String regexUsername = "^[A-Z][a-zA-Z]{5,12}$";

        return username.matches(regexUsername);
    }

    public boolean checkInputPassword(String password) {

        String regexPassword = "^.{6,12}$";

        return password.matches(regexPassword);
    }
}


