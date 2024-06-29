package javacafe.backend_files;


import javacafe.Models.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

///
public class FileController {


    private String formatText(User user) {
        String text = "";
        text = text.concat(user.getName());
        text = text.concat("|");
        text = text.concat(user.getPassword());
        text = text.concat("\n");

        return text;

    }

    public void writeNewRegister(User user) throws IOException {
        System.out.println("writeNewRegister called");
        BufferedWriter bw = new BufferedWriter(new FileWriter("backend_files/registers.txt", true));
        String text = formatText(user);
        bw.append(text);
        bw.close();
        incrementRegisters();
    }

    static User formatLine(String line) {
        String[] parts = line.split("\\|");
        return new User(parts[0], parts[1]);
    }

    public User reader(int desiredLine) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("backend_files/registers.txt"));
        String line = br.readLine();
        int i = 0;
        while(line != null) {
            if (desiredLine == i) {
                break;
            }
            i++;
            line = br.readLine();
        }
        assert line != null;
        User user = formatLine(line);
        br.close();
        return user;
    }

    /**
     * Leitura do arquivo count.txt para obter o número atual de usuários registrados.
     * @return
     * @throws IOException
     */
    public int getCurrentCount() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("backend_files/count.txt"));
        String string = br.readLine();
        return Integer.parseInt(string);

    }
    /**
     * Incrementa 1 no arquivo count.txt
     * @throws IOException
     */
    private void incrementRegisters() throws IOException {

        int oldValue = getCurrentCount();

        oldValue++;

        BufferedWriter bw = new BufferedWriter(new FileWriter("backend_files/count.txt", false));
        String newValue = String.valueOf(oldValue);
        bw.write(newValue);
        bw.close();
    }



}
