/**
 * Class to contain Organization's coordinates
 */
public class Coordinates 
{
    private long x;
    private Long y; //Поле не может быть null

    public Coordinates(String x, String y)
    {        
        this.x = Long.parseLong(x);
        if (y == null || y.length() == 0) 
        {
            System.out.println("help!");
        }
        this.y = Long.parseLong(y);
    }
}