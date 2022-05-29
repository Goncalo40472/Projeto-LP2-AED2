package NoWarPolis;

public class Login {

    public Login() {
    }

    public User logUser(String email, String password, BaseDeDados baseDeDados) {
        if (baseDeDados.searchUser(email) != null) {
            User user = baseDeDados.searchUser(email);
            if (user.checkPassword(password)) {
                System.out.println("\nSucessfully logged in!\n");
                return user;
            } else {
                System.out.println("\nWrong Password!\n");
                return null;
            }
        } else {
            System.out.println("\nUser does not exist or is admin user!\n");
            return null;
        }
    }

    public AdminUser logAdminUser(String email, String password, BaseDeDados baseDeDados) {
        if (baseDeDados.searchAdminUser(email) != null) {
            AdminUser adminUser = baseDeDados.searchAdminUser(email);
            if (adminUser.checkPassword(password)) {
                System.out.println("\nSucessfully logged in!\n");
                return adminUser;
            } else {
                System.out.println("\nWrong Password!\n");
                return null;
            }
        } else {
            System.out.println("\nUser does not exist or is basic user!\n");
            return null;
        }
    }

}
