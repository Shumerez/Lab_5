/**
 * Class to contain Organization's Address
 */
import java.util.Scanner;
public class Address 
{
    private String street; //���� ����� ���� null
    
    public Address(Scanner sc)
    {
        System.out.printf("�������� ����� ����������� (�����):%n>>>");
        String street = sc.nextLine();
        this.street = street;
        System.out.println("postalAddress created = " + street);
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