public class LoopChecker implements Checker {

    @Override
    public void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        checkLength(login, true);
        checkLength(password, false);
        checkCharacters(login, true);
        checkCharacters(login, false);
        checkPassword(password, confirmPassword);
    }

    private void checkCharacters(String s, boolean login) throws WrongLoginException, WrongPasswordException {
        if (s == null) {
            throwException(login, "null");
        }
        char[] chars = s.toCharArray();
        String validCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";
        for (char ch : chars) {
            if (validCharacters.contains(Character.toString(ch))) {
                continue;
            }
            throwException(login, "Некорректный символ");
        }
    }

    private void checkLength(String s, boolean login) throws WrongLoginException, WrongPasswordException {
        if (s != null && s.length() <= 20) {
            return;
        }
        throwException(login, "Некорректная длина");
    }

}
