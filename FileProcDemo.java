package catchPlagiarist;
import java.util.Scanner;


// -------------------------------------------------------------------------
/**
 *  Main method that uses ReadDoc when someone calls
 *  main({path, #{@link FileProcDemo})
 *
 *  @author lizzielitt
 *  @version Nov 16, 2015
 */
public class FileProcDemo
{
    private static double startTime = System.currentTimeMillis();

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param args arguments
     */
    public static void main(String[] args)
    {
        ReadDoc reader = new ReadDoc(args[0], args[1], args[2]);

        reader.readDir();

        reader.compareTrees();

        // calculate run time
        double endTime = System.currentTimeMillis();
        double duration = endTime - startTime;
        System.out.println("time: " + (duration / 1000.0) + " seconds");

    }

}
