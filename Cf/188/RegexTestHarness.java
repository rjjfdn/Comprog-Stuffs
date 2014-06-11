import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTestHarness {

    public static void main(String[] args) throws Exception {
    	BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        while (true) {

            Pattern pattern = 
            Pattern.compile(console.readLine());

            Matcher matcher = 
            pattern.matcher(console.readLine());

            boolean found = false;
            while (matcher.find()) {
                System.out.printf("I found the text" +
                    " \"%s\" starting at " +
                    "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
                found = true;
            }
        }
    }
}