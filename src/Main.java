public class Main {

    public static void main(String[] args) {
        String login = "serebrus";
        String password = "0000";
        String confirmPassword = "0000";
        boolean success = AuthService.validate(login, password,confirmPassword);
        if (success) {
            System.out.println("Проверка пройдена успешно");
        } else {
            System.out.println("Проверка не пройдена");
        }
    }

}