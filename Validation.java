/**
 * Created by nathan on 12/5/18.
 */
public class Validation {
    public static boolean isPlayerName(String name)
    {
        return name.length() <= 10 && name.matches("[A-Za-z]+-?[A-Za-z]+");
    }
}
