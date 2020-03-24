package app.rooms;

import app.library.Library;
import app.seats.Seat;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room implements Serializable {

    private String roomNo;
    private final Library library;
    private ArrayList<Seat> seats = new ArrayList<>();
    private boolean isAnySeatAvailable;

    public Room( String roomNo,Library library) throws IOException {

        this.roomNo = roomNo;
        this.library = library;

        addSeats(); // Adding Seats To The Room
        createRawFileOfRoomObject(); // Creating A Raw File Of The Room Object
        createCompleteRoomList();   // Creating A File Of The Room Numbers
        sortTheCompleteRoomList(); // Sorting That File Contents
    }

    public String getRoomNo(){
        return this.roomNo;
    }

    public Library getLibrary(){
        return this.library;
    }

    public ArrayList<Seat> geSeatList(){
        return this.seats;
    }

    public void addSeats() throws IOException{
        for (int i=1;i<=36;i++){
            seats.add(new Seat(getRoomNo()+new DecimalFormat("00").format(i),this));
        }
    }

    private void createRawFileOfRoomObject() throws IOException{
        FileOutputStream fos = new FileOutputStream("src\\app\\rooms\\" + getRoomNo() +".txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    private void createCompleteRoomList() throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\app\\rooms\\CompleteRoomList.txt", true));
        PrintWriter pw = new PrintWriter(bw);
        pw.println(getRoomNo());
        pw.close();
    }

    private void sortTheCompleteRoomList() throws IOException{
        // Reading The Room Numbers From A File
        // And Creating An Array Of The Book Numbers
        BufferedReader br = new BufferedReader(new FileReader("src\\app\\rooms\\CompleteRoomList.txt"));
        ArrayList<String> lines = new ArrayList<String>();
        String currentLine = br.readLine();
        while (currentLine != null) {
            lines.add(currentLine);
            currentLine = br.readLine();
        }
        br.close();

        // Sorting The Room Numbers
        Collections.sort(lines);

        // Adding The Sorted List To The Complete Room List
        BufferedWriter bw1 = new BufferedWriter(new FileWriter("src\\app\\rooms\\CompleteRoomList.txt"));
        for (String line : lines) {
            bw1.write(line);
            bw1.newLine();
        }
        bw1.close();
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    public boolean getAnySeatsAvailable(){
        for(int i =0 ;i<36; i++){
            if(seats.get(i).getIsAvailable())
                return true;
        }
        return false;
    }
}
