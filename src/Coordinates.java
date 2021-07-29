/**
 * Class to contain Organization's coordinates
 */
import java.util.Scanner;
public class Coordinates 
{
    private long x;
    private Long y; //Поле не может быть null

    public Coordinates(Scanner sc) // x - long, y - Long
    {        
        System.out.println("Creating Coordinates...");
        
        System.out.printf("Введите координату X организации:%n>>>");
        this.x = sc.nextLong();
        
        System.out.printf("Введите координату Y организации:%n>>>");
        this.y = sc.nextLong();
        
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