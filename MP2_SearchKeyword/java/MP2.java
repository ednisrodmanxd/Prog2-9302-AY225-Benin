import java.io.*;

public class MP2 {
    public static void main(String[] args) {

        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {

            System.out.print("Enter CSV file path: ");
            String path = scanner.nextLine();

            System.out.print("Enter keyword to search: ");
            String keyword = scanner.nextLine();

            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;

            // Search for keyword
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println(line);
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }
}