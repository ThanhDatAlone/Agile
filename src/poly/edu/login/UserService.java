package poly.edu.login;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    List<UserModel> listUser = new ArrayList<>();

    public void dataUser() {
        listUser.add(new UserModel("admin", "abc123@"));
    }

    public boolean checkLogin(String username, String pass) {
        for (UserModel u : listUser) {
            if (u.getUser().equals(username)
                    && u.getPassword().equals(pass)) {
                return true;
            }
        }
        return false;
    }
}
