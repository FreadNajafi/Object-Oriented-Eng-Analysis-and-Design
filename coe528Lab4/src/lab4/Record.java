package lab4;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Record {
// Name of the associated file

    private String filename;
    
    private static Record instance;

    public Record(String n) {
        filename = n;
    }
    
   public static Record getInstance(String n){
       if (instance == null){
           instance = new Record(n);
       }
       
       return instance;
    
}

// Effects: Reads and prints the contents of the associated
// file to the standard output.

    public void read() {
       try (Scanner scanner = new Scanner(new FileReader(filename))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

// Effects: Appends the specified message, msg, to the
// associated file.
    public void write(String msg) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(msg);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Fill the blank below that obtains the sole instance
        // of the Record class.
        // (You should not invoke the Record constructor here.)
        
        Record r = Record.getInstance("record.txt");
        
// Do not modify the code below
        r.write("Hello-1\n");
        r.write("Hello-2\n");
        System.out.println("Currently the file record.txt "
                + "contains the following lines:");
        r.read();
    }
}
