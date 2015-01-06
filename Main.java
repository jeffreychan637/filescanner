import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;

/** A script that takes in an input file and and an optional output file.
 *  It's left up to the coder to decide what do with these files. This is
 *  just a skeleton script.
 *
 *  @author Jeffrey Chan
 */
public class Main {

    /** An input file is provided in ARGS[0] and an optional output
     *  in ARGS[1]. Both files are subsequently opened and closed. It's
     *  left up to the coder to scan through the files and output
     *  something. */
    public static void main(String[] args) {
        if (args.length > 2 || args.length == 0) {
            usage();
            return;
        } else {
            try {
                Scanner input = new Scanner(new File(args[0]));
                BufferedWriter output = null;
                File outputFile = null;
                if (args.length == 2) {
                    outputFile = new File(args[1]);
                    output = new BufferedWriter(new PrintWriter(outputFile));
                } else {
                    try { 
                        outputFile = new
                            File("nameOfFile.txt");
                        output = new BufferedWriter(new FileWriter(outputFile));
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                }
                /** Do stuff here! 
                 *  for example (in another class):
                 *     try {
                 *         while input.hasNextLine() {
                 *             String line = input.nextLine()
                 *             String[] lineParts = line.split("Some Regex")
                 *             //deal with scanned line here
                 *         }
                 *         //process all scanned data
                 *         //or process each line while in the while loop
                 *         //output something based on the line or all the
                 *         //scanned data
                 *     } catch (IOException e) {
                 *          System.err.println(e.getMessage());
                 *          System.exit(1);
                 *     }
                 */
                input.close();
                output.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
        }
    }

    /** Prints a usage method - used if the wrong amount of arguments is
      * given. */
    public static void usage() {
        System.out.println("Usage: java <home_directory>/Main INPUT_FILE"
                            + " (Optional: OUTPUT_FILE)");
    }
}
