package app.books;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Book implements Serializable{
    private final String name;
    private final String author;
    private boolean isAvailable;

    public Book(String name, String author) throws IOException {

        this.name = name;
        this.author = author;
        this.isAvailable = true;

        createRawFileOfBookObject(); // Creating A Raw File Of The Book Object
        createCompleteBookList();   // Creating A File Of The Book Names
        sortTheCompleteBookList(); // Sorting That File Contents
    }

    public boolean getIsAvailable(){
        return this.isAvailable;
    }

    public void setIsAvailable(boolean decision){ this.isAvailable=decision; }

    public String getName(){
        return this.name;
    }

    public String getAuthor(){
        return this.author;
    }

    private void createRawFileOfBookObject() throws IOException{
        FileOutputStream fos = new FileOutputStream("src\\app\\books\\" + getName() +".txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    private void createCompleteBookList() throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\app\\books\\CompleteBookList.txt", true));
        PrintWriter pw = new PrintWriter(bw);
        pw.println(getName());
        pw.close();
    }

    private void sortTheCompleteBookList() throws IOException{
        // Reading The Book Names From A File
        // And Creating An Array Of The Book Names
        BufferedReader br = new BufferedReader(new FileReader("src\\app\\books\\CompleteBookList.txt"));
        ArrayList<String> lines = new ArrayList<String>();
        String currentLine = br.readLine();
        while (currentLine != null) {
            lines.add(currentLine);
            currentLine = br.readLine();
        }
        br.close();

        // Sorting The Book Names
        Collections.sort(lines);

        // Adding The Sorted List To The Complete Book List
        BufferedWriter bw1 = new BufferedWriter(new FileWriter("src\\app\\books\\CompleteBookList.txt"));
        for (String line : lines) {
            bw1.write(line);
            bw1.newLine();
        }
        bw1.close();
    }

}