/**
 进程练习
 * */
import java.io.IOException;
import java.util.Scanner;

public class ProcessTest {
    public static void main(String[] args) throws IOException {
        //ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ipconfig/all");
        //Process process = pb.start();
        String cmd="cmd "+"/c "+"ipconfig/all";
        Process process = Runtime.getRuntime().exec(cmd);
        Scanner scanner = new Scanner(process.getInputStream());

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}
