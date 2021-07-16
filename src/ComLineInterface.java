import java.io.File;
import java.lang.Long;
import java.util.Scanner;
import java.util.ArrayList;
// ��������� � Commands �����, ����� ������ ���������� ���������� ������
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// experimenting with array output
import java.util.Arrays;
// for sort operations
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Interpreting user input
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

class ComLineInterface
{
    private static Scanner sc = new Scanner(System.in);

    public static void fetchCommand()
    {
        System.out.print(">>>");
        String inputString = sc.nextLine();
        String command = new String();
        
        String[] inputArray = inputString.split(" ");
        command = inputArray[0];
        String[] arguments = new String[] {}; //must initialize arguments variable out of if
        
        if (inputString.contains(" "))
        {
            arguments = Arrays.copyOfRange(inputArray, 1, inputArray.length);
        }
        
        switch (command) {
            case ("help"):
               executeHelp();
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("info"):
               //executeInfo;
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("show"):
               executeShow();
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("add"):
               executeAdd();
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("update"):
               //executeUpdate();
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("remove_by_id"): //in progress
               if ((arguments[0].chars().allMatch( Character::isDigit )) && (arguments.length == 1))
               {
                   
                   executeRemoveById(Integer.valueOf(arguments[0]));
               }
               System.out.printf("Wrong arguments. remove_by_id command needs exactly 1 numeric argument.%nYou entered " + arguments + "%nEnter command again, please.");
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("clear"):
               executeClear();
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("execute_script"):
               //executeScript();
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("exit"):
               //executeExit();
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("remove_first"):
               executeRemoveFirst();
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("remove_last"):
               executeRemoveLast();
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("shuffle"):
               //executeShuffle();
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("count_by_postal_address"):
               //executeCountByPostalAddress();
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("filter_starts_with_name"):
               //executeFilterStartsWithName();
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("print_descending"):
               executePrintDescending();
               System.out.printf("%n%n");
               fetchCommand();
               break;
            default:
               System.out.println("You entered some bullshit (" + inputString + "). Again, pls");
               fetchCommand();
               break;
        }
        sc.close(); // closing scanner
    }
    public static void executeHelp()
    {
        System.out.printf("help : ������� ������� �� ��������� ��������%ninfo : ������� � ����������� ����� ������ ���������� � ��������� (���, ���� �������������, ���������� ��������� � �.�.)%nshow : ������� � ����������� ����� ������ ��� �������� ��������� � ��������� �������������%nadd {element} : �������� ����� ������� � ���������%nupdate id {element} : �������� �������� �������� ���������, id �������� ����� ���������%nremove_by_id id : ������� ������� �� ��������� �� ��� id%nclear : �������� ���������%nsave : ��������� ��������� � ����%nexecute_script file_name : ������� � ��������� ������ �� ���������� �����. � ������� ���������� ������� � ����� �� ����, � ������� �� ������ ������������ � ������������� ������.%nexit : ��������� ��������� (��� ���������� � ����)%nremove_first : ������� ������ ������� �� ���������%nremove_last : ������� ��������� ������� �� ���������%nshuffle : ���������� �������� ��������� � ��������� �������%ncount_by_postal_address postalAddress : ������� ���������� ���������, �������� ���� postalAddress ������� ����� ���������%nfilter_starts_with_name name : ������� ��������, �������� ���� name ������� ���������� � �������� ���������%nprint_descending : ������� �������� ��������� � ������� ��������");
    }
    public static void executeShow()
    {
        System.out.println(FileManager.orgList);
    }
    public static void executeAdd()
    {
        System.out.println("���������� ���������� ������ �������� � ���������...");
        // Generating ID id (ok)
        System.out.println("Creating ID...");
        Integer id = 1 + FileManager.orgList.get(FileManager.orgList.size() - 1).getId(); //getting max+1 ID for new organization      
        System.out.println("ID created.");
        
        // Entering Name name (ok)
        System.out.println("Creating Name...");
        
        String name = "Error. You wasn't supposed to see this. Code 9011";
        do
        {
            System.out.printf("������� ��� �����������:%n>>>");
            name = sc.nextLine();
            if  (isBlankString(name))
            {
                System.out.println("Your string is empty. Enter smth, please");
            }
        }
        while (isBlankString(name));
        System.out.println("Right name entered. It is non-empty string. Name = " + name);
        
        System.out.println("NAME created.");
        
       
        // Entering Coordinates coordinates (ok)
        Coordinates coordinates = new Coordinates(sc);
        
        // working on DATE date (ok)
        System.out.println("Creating creationDate...");
        System.out.printf("������� ���� ��������:%n>>>");
        
        sc.nextLine(); // clear buffer
        
        String str = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date = LocalDateTime.parse(str, formatter);
        System.out.println("creationDate created = " + date);
        
        
        // working on annualTurnover turnover (ok)
        System.out.println("Creating annualTurnover...");
        System.out.printf("������� ��������� ������:%n>>>");
        Integer turnover = sc.nextInt();
        System.out.print("annualTurnover created = " + turnover);
        
        
        // working on OrganizationType type (ok)
        OrganizationType type = OrganizationType.chooseType(sc);
       
        // set postalAddress address (ok)
        Address address = new Address(sc);
        
        Organization org = new Organization(id, name, coordinates, date, turnover, type, address);
        FileManager.orgList.add(org);
        
        System.out.println(FileManager.orgList);
    }
    public static void executeRemoveById(Integer id)
    {
        System.out.println("Succesful removing by id " + id);
    }
    public static void executeClear()
    {
        FileManager.orgList.clear();
        System.out.println("Array cleared");
    }
    public static void executeRemoveFirst()
    {
        try
        {
            FileManager.orgList.remove(0);
            System.out.println("First element removed. It's id were 0");
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Array is already empty!");
        }
    }
    public static void executeRemoveLast()
    {
        try
        {
            FileManager.orgList.remove(FileManager.orgList.size() - 1);
            System.out.println("Last element removed. It's id were: " + (FileManager.orgList.size() + 1));
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Array is already empty!");
        }
    }
    public static void executePrintDescending()
    {
        Comparator<Organization> idComparator = (o1, o2) -> o1.getId().compareTo(o2.getId()); // override compareTo method 
                                                                                              // for our Organization class
        FileManager.orgList.sort(idComparator.reversed()); // sort in reverse
        
        System.out.println(FileManager.orgList); // print sorted in reverse
        
        FileManager.orgList.sort(idComparator); // sort to the normal state
    }
    static boolean isBlankString(String string)
    {
        return string == null || string.trim().isEmpty();
    }
}