package app.login;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.lang.String;
import java.lang.*;

public class LoginHandler {
    public static boolean authenticate(String username, String password) {
        File usersDatabase;
        usersDatabase = new File("usersDatabase.txt");

        Scanner scanner = null;
        try {
            scanner = new Scanner(usersDatabase);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] str = line.split("#", 9);
                System.out.println(str[0] + " " + username + "\n" + str[1] + " " + password);
                if (str[0].equals(username) && str[1].equals(password)) return true;
            }
        }catch (NullPointerException e){
            System.out.println(e);
        }

        return false;
    }

}
