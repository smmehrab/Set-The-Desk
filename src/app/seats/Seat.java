package app.seats;

import app.rooms.Room;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Seat implements Serializable {
	private String seatNo;
	private Room room;
	private boolean isAvailable;

	public Seat(String seatNo, Room room) throws IOException {

		this.seatNo=seatNo;
		this.room=room;
		this.isAvailable=true;

		createRawFileOfSeatObject(); // Creating A Raw File Of The Seat Object
		createCompleteSeatList();   // Creating A File Of The Seat Numbers
		sortTheCompleteSeatList(); // Sorting That File Contents
	}

	public boolean getIsAvailable(){
		return this.isAvailable;
	}

	public String getSeatNo(){
		return this.seatNo;
	}

	public Room getRoom(){
		return this.room;
	}

	public void setIsAvailable(boolean decision){ this.isAvailable=decision; }

	private void createRawFileOfSeatObject() throws IOException{
		FileOutputStream fos = new FileOutputStream("src\\app\\seats\\"+ getSeatNo() +".txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.flush();
		oos.close();
	}

	private void createCompleteSeatList() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter("src\\app\\seats\\CompleteSeatList.txt", true));
		PrintWriter pw = new PrintWriter(bw);
		pw.println(getSeatNo());
		pw.close();
	}

	private void sortTheCompleteSeatList() throws IOException{
		// Reading The Seat Numbers From A File
		// And Creating An Array Of The Seat Numbers
		BufferedReader br = new BufferedReader(new FileReader("src\\app\\seats\\CompleteSeatList.txt"));
		ArrayList<String> lines = new ArrayList<String>();
		String currentLine = br.readLine();
		while (currentLine != null) {
			lines.add(currentLine);
			currentLine = br.readLine();
		}
		br.close();

		// Sorting The Seat Numbers
		Collections.sort(lines);

		// Adding The Sorted List To The Complete Seat List
		BufferedWriter bw1 = new BufferedWriter(new FileWriter("src\\app\\seats\\CompleteSeatList.txt"));
		for (String line : lines) {
			bw1.write(line);
			bw1.newLine();
		}
		bw1.close();
	}
}