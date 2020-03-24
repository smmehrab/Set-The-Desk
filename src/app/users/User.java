package app.users;

import app.books.Book;
import app.library.Library;
import app.rooms.Room;
import app.seats.Seat;

import java.io.*;
import java.util.ArrayList;

public class User implements Serializable {
    private String username;
    private String password;
    private String name;
    private String gender;
    private String email;
    private String age;
    private Seat bookedSeat;
    private ArrayList<Book> currentBorrowedBooks = new ArrayList<>();
    private ArrayList<Book> historyOfBorrowedBooks = new ArrayList<>();

    public User(String username, String password, String name, String email, String age, String mobileNumber, String gender) throws IOException {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.age = age;
        this.mobileNumber = mobileNumber;
        this.gender = gender;

        createRawFileOfUserObject(); // Creating A Raw File Of The Book Object
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    private String mobileNumber;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean borrowBook(String command) throws ClassNotFoundException, IOException {

        ObjectInputStream objectIn = null;

        try {
            objectIn = new ObjectInputStream(new FileInputStream("src\\app\\books\\" + command + ".txt"));
        } catch (IOException e) {
            System.out.println("Pay nai");
            return false;
        }

        Book book = (Book) objectIn.readObject();
        objectIn.close();

        if (!book.getIsAvailable())
            return false;
        else {
            book.setIsAvailable(false);
            currentBorrowedBooks.add(book);
            historyOfBorrowedBooks.add(book);
            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream("src\\app\\books\\" + command + ".txt"));
            objectOut.writeObject(book);
            objectOut.close();
            return true;
        }
    }

    public Seat getBookedSeat() {
        return bookedSeat;
    }

    public void setBookedSeat(Seat bookedSeat) {
        this.bookedSeat = bookedSeat;
    }

    public ArrayList<Book> getCurrentBorrowedBooks() {
        return currentBorrowedBooks;
    }

    public void setCurrentBorrowedBooks(ArrayList<Book> currentBorrowedBooks) {
        this.currentBorrowedBooks = currentBorrowedBooks;
    }

    public ArrayList<Book> getHistoryOfBorrowedBooks() {
        return historyOfBorrowedBooks;
    }

    public void setHistoryOfBorrowedBooks(ArrayList<Book> historyOfBorrowedBooks) {
        this.historyOfBorrowedBooks = historyOfBorrowedBooks;
    }

    public boolean returnBook(String command) throws IOException, ClassNotFoundException {
        ObjectInputStream objectIn = null;

        try {
            objectIn = new ObjectInputStream(new FileInputStream("src\\app\\books\\" + command + ".txt"));
        } catch (IOException e) {
            return false;
        }

        Book book = (Book) objectIn.readObject();
        objectIn.close();

        if (!book.getIsAvailable()) {
            book.setIsAvailable(true);
            currentBorrowedBooks.remove(book);
            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream("src\\app\\books\\" + command + ".txt"));
            objectOut.writeObject(book);
            objectOut.close();
            return true;
        } else {
            return false;
        }
    }

    public boolean bookSeat(String command) throws IOException, ClassNotFoundException {
        int len = command.length();
        String lib = command.substring(0, len - 5);
        String ro = command.substring(0, len - 2);
        //System.out.println(lib);
        int roomIndex = Integer.parseInt(command.substring(len - 3, len - 2)) - 1;
        //System.out.println(Integer.parseInt(roomIndex) - 1);
        int seatIndex = Integer.parseInt(command.substring(len - 2, len)) - 1;
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("src\\app\\library\\" + lib + ".txt"));
        } catch (IOException e) {
            System.out.println("Pay nai");
            return false;
        }

        Library library = (Library) ois.readObject();
        ois.close();

        ObjectInputStream oisRoom = null;

        try {
            oisRoom = new ObjectInputStream(new FileInputStream("src\\app\\rooms\\" + ro + ".txt"));
        } catch (IOException e) {
            System.out.println("Pay nai");
            return false;
        }

        Room room = (Room) oisRoom.readObject();
        oisRoom.close();

        if (!(library.getRooms().get(roomIndex).getSeats().get(seatIndex).getIsAvailable()) || !(room.getSeats().get(seatIndex).getIsAvailable()))
            return false;
        else {
            library.getRooms().get(roomIndex).getSeats().get(seatIndex).setIsAvailable(false);
            //System.out.println("hello"+library.getRooms().get(roomIndex).getSeats().get(seatIndex).getIsAvailable());
            bookedSeat = library.getRooms().get(roomIndex).getSeats().get(seatIndex);

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\app\\library\\" + lib + ".txt"));
            oos.writeObject(library);
            oos.close();

            room.getSeats().get(seatIndex).setIsAvailable(false);
            //System.out.println("hello"+library.getRooms().get(roomIndex).getSeats().get(seatIndex).getIsAvailable());
            bookedSeat = library.getRooms().get(roomIndex).getSeats().get(seatIndex);

            ObjectOutputStream oosRoom = new ObjectOutputStream(new FileOutputStream("src\\app\\rooms\\" + ro + ".txt"));
            oosRoom.writeObject(room);
            oosRoom.close();

            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream("src\\app\\seats\\" + command + ".txt"));
            objectOut.writeObject(library.getRooms().get(roomIndex).getSeats().get(seatIndex));
            objectOut.close();
            return true;
        }

        /*ObjectInputStream objectIn = null;

        try {
            objectIn = new ObjectInputStream(new FileInputStream("src\\app\\seats\\"+command+".txt"));
        } catch (IOException e) {
            System.out.println("Pay nai");
            return false;
        }

        Seat seat = (Seat)objectIn.readObject();
        objectIn.close();

        if (!seat.getIsAvailable())
            return false;
        else{
            seat.setIsAvailable(false);
            bookedSeat = seat;
            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream("src\\app\\seats\\"+command+".txt"));
            objectOut.writeObject(seat);
            objectOut.close();
            return true;
        }
    }

    public boolean leaveSeat(String command) throws IOException, ClassNotFoundException {
        ObjectInputStream objectIn = null;

        try {
            objectIn = new ObjectInputStream(new FileInputStream("src\\app\\seats\\"+command+".txt"));
        } catch (IOException e) {
            return false;
        }

        Seat seat = (Seat)objectIn.readObject();
        objectIn.close();

        if (!seat.getIsAvailable()){
            seat.setIsAvailable(true);
            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream("src\\app\\seats\\"+command+".txt"));
            objectOut.writeObject(seat);
            objectOut.close();
            return true;
        }
        else{
            return false;
        }*/
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private void createRawFileOfUserObject() throws IOException {
        FileOutputStream fos = new FileOutputStream("src\\app\\users\\" + getUsername() + ".txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

}