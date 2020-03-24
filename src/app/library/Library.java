package app.library;

import app.books.Book;
import app.rooms.Room;
import app.books.Book;
import app.rooms.Room;
import app.seats.Seat;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Library implements Serializable {
    private String name;
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Book> books;

    public Library(String name) throws IOException {
        this.name = name;
        for (int i=1;i<=9;i++){
            rooms.add(new Room(getName()+"10"+i,this));
        }

        FileOutputStream fos = new FileOutputStream("src\\app\\library\\"+getName()+".txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\app\\library\\LibraryList.txt", true));
        PrintWriter pw = new PrintWriter(bw);
        pw.println(getName());
        pw.close();
        BufferedReader br = new BufferedReader(new FileReader("src\\app\\library\\LibraryList.txt"));
        ArrayList<String> lines = new ArrayList<String>();
        String currentLine = br.readLine();

        while (currentLine != null)
        {
            lines.add(currentLine);
            currentLine = br.readLine();
        }
        br.close();

        Collections.sort(lines);

        BufferedWriter bw1 = new BufferedWriter(new FileWriter("src\\app\\library\\LibraryList.txt"));

        for (String line : lines)
        {
            bw1.write(line);

            bw1.newLine();
        }
        bw1.close();

    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addRoom(Room room){

        rooms.add(room);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void addBook(Book book){
        books.add(book);
    }




}
