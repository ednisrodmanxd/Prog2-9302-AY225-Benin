import java.io.*;

public class MP3 {
    public static void main(String[] args) {

        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {

            System.out.print("Enter CSV file path: ");
            String path = scanner.nextLine();

            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            int count = 0;

            // Count non-empty rows
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    count++;
                }
            }

            br.close();

            System.out.println("Total valid rows: " + count);

        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }
}