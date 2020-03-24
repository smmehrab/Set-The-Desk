package app.register;

import java.io.*;
import java.lang.*;

public class RegisterHandler {
    public static boolean authenticate(String username, String pass, String confirmPass, String fullname, String email,
                                       String mobile, String gender, String age) {

        // Checking The Validity Of Each Input Field And Returning The Validity Of Overall User Input
        return (ifFullnameValid(fullname) && ifUsernameValid(username) && ifPassValid(pass, confirmPass) &&
                ifEmailValid(email) && ifMobileValid(mobile) && ifAgeValid(age));
        //return true;S
    }

    public static void register(String username, String pass, String fullname, String email,
                                String mobile, String gender, String age) throws IOException {

        String userData = username + "#" + pass + "#" + fullname + "#" + email + "#" + mobile + "#" + gender + "#" + age;

        // Opening The Users Database File
        File usersDatabase;
        usersDatabase = new File("usersDatabase.txt");

        // Creating The Writer Who Will Append Latest Data
        BufferedWriter bwriter = new BufferedWriter(new FileWriter(usersDatabase, true));
        PrintWriter pwriter = new PrintWriter(bwriter);

        // Appending The User Data
        pwriter.println(userData);

        // Closing The File
        pwriter.close();
    }

    private static boolean ifFullnameValid(String fullname){
        // Checking Length Range Of Fullname
        if(fullname.length()>20 || fullname.length()<8)
            return false;

        // Only a-z And Space Are Allowed
        // Character After A Space, Must Be In Uppercase
        boolean cap = true;
        for(int index = 0; index < fullname.length(); index ++ ) {

            char character = fullname.charAt(index);

            if(character == ' ')
                cap = true;

            else if (cap) {
                if (!(character >= 'A' && character <= 'Z'))
                    return false;
                cap = false;
            }

            else{
                if (!(character >= 'a' && character <= 'z'))
                    return false;
            }
        }

        // Fullname Is Valid
        return true;
    }

    private static boolean ifUsernameValid(String username){
        // Checking Length Range Of Username
        if(username.length()>20 || username.length()<8)
            return false;

        // Only a-z, '.' And '_' Are Allowed
        for(int index = 0; index < username.length(); index ++ ) {
            if (!((username.charAt(index) >= 'a' && username.charAt(index) <= 'z') || username.charAt(index)=='.'
                || username.charAt(index)=='_'))
                return false;
        }

        // Username Is Valid
        return true;
    }

    private static boolean ifEmailValid(String email){
        // Only a-z, 0-9, '.', '@' Are Valid In Email
        for(int index = 0; index < email.length(); index ++ ) {
            if (!(((email.charAt(index) >= 'a' && email.charAt(index) <= 'z')
                    || ((email.charAt(index) >= '0' && email.charAt(index) <= '9')))
                    || email.charAt(index)!= '.' || email.charAt(index)!= '@'))
                return false;
        }

        // Only One '@' Symbol Allowed
        int count = 0;
        for(int index = 0; index < email.length(); index ++ ) {
            if(email.charAt(index)=='@') count++;
        }
        if(count!=1)
            return false;

        // There Must Be At Least One '.' Symbol
        count =0;
        for(int index = 0; index < email.length(); index ++ ) {
            if(email.charAt(index)=='.') count++;
        }
        if(count ==0)
            return false;

        // Email Is Valid
        return true;
    }

    private static boolean ifMobileValid(String mobile){
        // Checking Minimum Mobile Number Length
        if(mobile.length()<10)
            return false;
        return true;
    }

    private static boolean ifAgeValid(String age){
        int ageInt;

        // Checking If User Entered An Integer Or Not
        try {
            ageInt = Integer.parseInt(age);
        }catch (Exception e){
            return false;
        }

        // Checking Valid Age Range
        if(ageInt > 130 || ageInt < 8)
            return false;

        // Age Is Valid
        return true;
    }

    private static boolean ifPassValid(String pass, String confirmPass){

        // Checking Minimum Pass Length
        if(pass.length()<8)
            return false;

        // Checking If User Confirmed Password Correctly Or Not
        return pass.equals(confirmPass);
    }
}
