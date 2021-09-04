/**
 * Class to contain Organization's coordinates
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class Coordinates 
{
    private long x;
    private Long y; //Поле не может быть null

    public Coordinates(Scanner sc) // x - long, y - Long
    {        
        System.out.println("Creating Coordinates...");
        
        boolean inputIsRight; // flag for input check
        do
        {
            inputIsRight = true; // initial flag is true - if no errors, do cycle will end
            
            try 
            { 
                System.out.printf("Введите координату X организации:%n>>>");
                this.x = ComLineInterface.sc.nextLong();
                // if (ComLineInterface.isBlankString(Long.toString(this.x))) { throw new InputMismatchException("Null input"); }
            }
            catch (InputMismatchException e) { System.out.println("Input error. Input Long value again, please."); inputIsRight = false; sc.nextLine();} // error - show message, set flag false, clear scanner buffer
        }
        while (!inputIsRight); // checking flag
        
        do
        {
            inputIsRight = true; // initial flag is true - if no errors, do cycle will end

            try 
            { 
                System.out.printf("Введите координату Y организации:%n>>>");
                this.y = ComLineInterface.sc.nextLong(); 
                // if (ComLineInterface.isBlankString(Long.toString(this.y))) { throw new InputMismatchException("Null input"); }
            }
            catch (InputMismatchException e) { System.out.println("Input error. Input Long value again, please."); inputIsRight = false; sc.nextLine();} // error - show message, set flag false, clear scanner buffer
        }
        while (!inputIsRight); // checking flag
        
        System.out.println("Coordinates created = " + x + " and " + y);
    }

    public Coordinates(long x, Long y)
    {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString()
    {
        return x + ", " + y;
    }
}