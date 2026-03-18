import java.io.*;

public class MP {
    public static void main(String[] args) {

        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {

            // Ask user for file path
            System.out.print("Enter CSV file path: ");
            String path = scanner.nextLine();

            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            int count = 0;

            // Display first 10 rows
            while ((line = br.readLine()) != null && count < 10) {
                System.out.println(line);
                count++;
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }
}