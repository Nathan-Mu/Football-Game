import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by nathan on 12/5/18.
 */
public class FileIO {

    public static ArrayList<String> readFile(String filename)
    {
        ArrayList<String> teams = new ArrayList<>();
        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine())
            {
                teams.add(parser.nextLine());
            }
            inputFile.close();
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(filename + " not found");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }

        return teams;
    }
}
