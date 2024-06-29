package javacafe.backend_files;

import javacafe.Models.User;

import java.io.IOException;

public class LoginController{

    /**
     * Verifica se o usuário passado está no arquivo registers.txt
     * @param user User
     * @return true se o usuário é encontrado, false se não é encontrado
     * @throws IOException
     */
    public boolean validUser(User user) throws IOException {
        FileController fc = new FileController();
        int n = fc.getCurrentCount();
        for (int i = 0; i < n; i++) {
            User u = fc.reader(i);
            if ((u.getName().equals(user.getName())) && (u.getPassword().equals(user.getPassword()))) {
                return true;
            }
        }

        return false;
    }


}