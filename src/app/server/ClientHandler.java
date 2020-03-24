package app.server;

import app.books.Book;
import app.library.Library;
import app.login.LoginHandler;
import app.register.RegisterHandler;
import app.rooms.Room;
import app.seats.Seat;
import app.users.User;

import java.io.*;
import java.net.*;

class ClientHandler implements Runnable
{
    private String name;
    private User user;
    final DataOutputStream dos;
    final DataInputStream dis;
    Socket s;
    boolean isloggedin;

    // Constructor
    public ClientHandler(Socket s, String name, DataInputStream dis, DataOutputStream dos) {
        this.dis = dis;
        this.dos = dos;
        this.name = name;
        this.s = s;
        this.isloggedin=true;
    }

    @Override
    public void run() {

        String received = "";
        boolean decision;
        while (true)
        {
            try
            {
                // receive the string
                received = dis.readUTF();

                System.out.println(received);

                if(received.equals("Logout")){
                    this.isloggedin=false;
                    this.s.close();
                    break;
                }

                else {
                    String string[] = received.split("/",2);

                    if(string[0].equals("Register")){
                        String str[] = string[1].split("#",9);

                        decision = app.register.RegisterHandler.authenticate(str[0],str[1],str[2],str[3],str[4],str[5],
                                                                                str[6],str[7]);

                        if(decision == true)
                            RegisterHandler.register(str[0],str[1],str[2],str[3],str[4],str[5],str[6]);

                        dos.writeUTF(String.valueOf(decision));
                        dos.flush();

                    }

                    else if(string[0].equals("Login")){
                        String str[] = string[1].split("#",2);

                        decision = LoginHandler.authenticate(str[0],str[1]);
                        dos.writeUTF(String.valueOf(decision));
                        dos.flush();

                        if(decision){
                            ObjectInputStream objectIn = null;
                            try {
                                objectIn = new ObjectInputStream(new FileInputStream("src\\app\\users\\"+str[0]+".txt"));
                            } catch (IOException e) {System.out.println(e);
                            }
                            User user = (User)objectIn.readObject();
                            objectIn.close();
                        }
                    }

                    else if(string[0].equals("GetRoomList")){
                        ObjectInputStream objectIn=null;
                        String output="";
                        try {
                            //FileInputStream fis = new FileInputStream("src\\app\\library\\Central Library.txt");
                            objectIn = new ObjectInputStream(new FileInputStream("src\\app\\library\\"+ string[1] +".txt"));
                        } catch (IOException e) {
                            System.out.println("Not Found");
                        }

                        Library library = (Library) objectIn.readObject();
                        //System.out.println(library.getRooms().get(0).getRoomNo());
                        objectIn.close();

                        for(int index =0 ; index< 9;index++){
                            int len = library.getRooms().get(index).getRoomNo().length();
                            output += library.getRooms().get(index).getRoomNo().substring(len - 3, len);
                            if(index<8) {
                                output+="#";
                            }
                        }
                        dos.writeUTF(output);
                        dos.flush();
                        objectIn.close();
                    }

                    else if(string[0].equals("GetSeatList")){
                        /*ObjectInputStream objectIn=null;
                        String output="";
                        try {
                            //FileInputStream fis = new FileInputStream("src\\app\\library\\Central Library.txt");
                            objectIn = new ObjectInputStream(new FileInputStream("src\\app\\rooms\\"+ string[1] + ".txt"));
                        } catch (IOException e) {
                            System.out.println("Not Found");
                        }
                        Room room = (Room) objectIn.readObject();
                        // System.out.println(room.getSeats().get(0).getSeatNo());
                        objectIn.close();

                        for(int index =0 ; index< 36;index++){
                            int len = room.getSeats().get(index).getSeatNo().length();
                            output += room.getSeats().get(index).getSeatNo().substring(len-2, len);
                            if(index<35) {
                                output+="#";
                            }
                        }
                        dos.writeUTF(output);
                        dos.flush();
                        objectIn.close();

                         */

                        BufferedReader br = new BufferedReader(new FileReader("src\\app\\seats\\CompleteSeatList.txt"));
                        String currentLine = br.readLine();

                        String output = "";
                        int cnt = 0;
                        while (currentLine != null) {
                            int len = currentLine.length();
                            String tmp =  currentLine.substring(len-5, len-2);

                            if(string[1].equals(tmp)) {
                                output += currentLine.substring(len - 2, len);
                                cnt ++;
                                if(cnt < 36)
                                    output += "#";
                            }
                            currentLine = br.readLine();
                        }
                        br.close();

                        dos.writeUTF(output);
                        dos.flush();
                    }

                    else if(received.length()==1){
                        BufferedReader br;
                        String currentLine;
                        if(received.charAt(0)!='*') {
                            br = new BufferedReader(new FileReader("src\\app\\books\\" + received.charAt(0) + ".txt"));
                            currentLine = br.readLine();
                        }
                        else {
                            br = new BufferedReader(new FileReader("src\\app\\books\\Others.txt"));
                            currentLine = br.readLine();
                        }


                        String output = "";

                        int cnt =0;
                        while (cnt < 10) {
                            output += currentLine;
                            currentLine = br.readLine();
                            cnt++;
                            if(cnt != 9)
                                output+="#";
                        }
                        br.close();

                        dos.writeUTF(output);
                        dos.flush();
                    }

                    else if(string[0].equals("Borrow")){
                        decision = user.borrowBook(string[1]);
                        dos.writeUTF(String.valueOf(decision));
                        dos.flush();
                    }
                    else  if(string[0].equals("BookSeat")){
                        decision = user.bookSeat(string[1]);
                        dos.writeUTF(String.valueOf(decision));
                        dos.flush();
                    }
                    else if(string[0].equals("IsBookAvailable")){
                        ObjectInputStream objectIn = null;
                        try {
                            objectIn = new ObjectInputStream(new FileInputStream("src\\app\\books\\"+string[1]+".txt"));
                        } catch (IOException e) {System.out.println(e);
                        }
                        Book book = (Book) objectIn.readObject();
                        objectIn.close();
                        decision=book.getIsAvailable();
                        dos.writeUTF(String.valueOf(decision));
                    }
                    else if(string[0].equals("IsAnySeatAvailable")){
                        ObjectInputStream objectIn = null;
                        try {
                            objectIn = new ObjectInputStream(new FileInputStream("src\\app\\books\\"+string[1]+".txt"));
                        } catch (IOException e) {System.out.println(e);
                        }
                        Room room = (Room) objectIn.readObject();
                        objectIn.close();
                        decision=room.getAnySeatsAvailable();
                        dos.writeUTF(String.valueOf(decision));

                    }
                    else if(string[0].equals("IsSeatAvailable")){
                        ObjectInputStream objectIn = null;
                        try {
                            objectIn = new ObjectInputStream(new FileInputStream("src\\app\\books\\"+string[1]+".txt"));
                        } catch (IOException e) {System.out.println(e);
                        }
                        Seat seat = (Seat) objectIn.readObject();
                        objectIn.close();
                        decision=seat.getIsAvailable();
                        dos.writeUTF(String.valueOf(decision));

                    }

                    else if(string[0].equals("GetMyCurrentBorrowedBookList")){
                        String output="";


                        for(int i =0 ; i< 9;i++){
                            output+=user.getCurrentBorrowedBooks().get(0).getName();
                            if(i<8) {
                                output+="#";
                            }
                        }
                        dos.writeUTF(output);
                    }
                    else if(string[0].equals("GetMyAllBorrowedBookList")){
                        String output="";


                        for(int i =0 ; i< 9;i++){
                            output+=user.getHistoryOfBorrowedBooks().get(0).getName();
                            if(i<8) {
                                output+="#";
                            }
                        }
                        dos.writeUTF(output);
                    }
                }



                // break the string into message and recipient part


                // search for the recipient in the connected devices list.
                // ar is the vector storing client of active users
                /*for (ClientHandler mc : LibraryServer.ar)
                {
                    // if the recipient is found, write on its
                    // output stream
                    if (mc.name.equals(recipient) && mc.isloggedin==true)
                    {
                        mc.dos.writeUTF(this.name+" : "+MsgToSend);
                        break;
                    }
                }*/
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

        try {
            // closing resources
            this.dis.close();
            this.dos.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}