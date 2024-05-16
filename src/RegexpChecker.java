public class RegexpChecker implements Checker {

    @Override
    public void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        String regexp = "^\\w{1,20}$";
        if (login == null) {
            throwException(true, "null");
        }
        if (password == null || confirmPassword == null) {
            throwException(false, "null");
        }
        if (!login.matches(regexp)) {
            throwException(true, "Неверные символы или длина");
        }
        if (!password.matches(regexp)) {
            throwException(false, "Неверные символы или длина");
        }
        checkPassword(password, confirmPassword);
    }
}
