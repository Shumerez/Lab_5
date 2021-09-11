/**
 * Class to contain Organization's Address
 */
import java.util.Scanner;
public class Address 
{
    private String street; //Поле может быть null
    
    public Address(Scanner sc)
    {
        System.out.printf("Назовите адрес организации (улицу):%n>>>");
        String street = sc.nextLine();
        if (ComLineInterface.isBlankString(street))
        {
            this.street = null; // this variable can be null
            System.out.println("postalAddress created: null");
        }
        else
        {
            this.street = street;
            System.out.println("postalAddress created: " + street);
        }
    }
    public Address(String street)
    {
        this.street = street;    
    }
    @Override
    public String toString()
    {
        return this.street;
    }
}