/**
 * Class to contain Organization's coordinates
 */
import java.util.Scanner;
public class Coordinates 
{
    private long x;
    private Long y; //���� �� ����� ���� null

    public Coordinates(Scanner sc) // x - long, y - Long
    {        
        System.out.println("Creating Coordinates...");
        
        System.out.printf("������� ���������� X �����������:%n>>>");
        this.x = sc.nextLong();
        
        System.out.printf("������� ���������� Y �����������:%n>>>");
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