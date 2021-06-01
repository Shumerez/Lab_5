import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Interpreting user input
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

class ComLineInterface
{
    // Using Scanner for Getting Input from User
    private static Scanner sc = new Scanner(System.in);
    /*
    public static void main(String[] args)
    {
        fetchCommand();
        sc.close();  // closing scanner from fetchCommand method
    }
    */
    public static void fetchCommand(ArrayList orgList)
    {
        System.out.print(">>>");
        String command = sc.nextLine();
        
        
        
        //System.out.println("You entered command: \"" + command + "\"");
        //int a = in.nextInt();
        //System.out.println("You entered integer " + a);
        //float b = in.nextFloat();
        //System.out.println("You entered float " + b);
        
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
               //executeShow;
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("add"):
               executeAdd(orgList);
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("update"):
               //executeUpdate();
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("remove_by_id"):
               //executeRemoveById();
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("clear"):
               //executeClear;
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
               //executeRemoveFirst();
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("remove_last"):
               //executeRemoveLast();
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
               //executePrintDescending();
               System.out.printf("%n%n");
               fetchCommand();
               break;
            default:
               System.out.println("You entered some bullshit (" + command + "). Again, pls");
               fetchCommand();
               break;
        }
            
        // closing scanner
        sc.close();
    }
    public static void executeHelp()
    {
        System.out.printf("help : ������� ������� �� ��������� ��������%ninfo : ������� � ����������� ����� ������ ���������� � ��������� (���, ���� �������������, ���������� ��������� � �.�.)%nshow : ������� � ����������� ����� ������ ��� �������� ��������� � ��������� �������������%nadd {element} : �������� ����� ������� � ���������%nupdate id {element} : �������� �������� �������� ���������, id �������� ����� ���������%nremove_by_id id : ������� ������� �� ��������� �� ��� id%nclear : �������� ���������%nsave : ��������� ��������� � ����%nexecute_script file_name : ������� � ��������� ������ �� ���������� �����. � ������� ���������� ������� � ����� �� ����, � ������� �� ������ ������������ � ������������� ������.%nexit : ��������� ��������� (��� ���������� � ����)%nremove_first : ������� ������ ������� �� ���������%nremove_last : ������� ��������� ������� �� ���������%nshuffle : ���������� �������� ��������� � ��������� �������%ncount_by_postal_address postalAddress : ������� ���������� ���������, �������� ���� postalAddress ������� ����� ���������%nfilter_starts_with_name name : ������� ��������, �������� ���� name ������� ���������� � �������� ���������%nprint_descending : ������� �������� ��������� � ������� ��������");
    }
    public static ArrayList executeAdd(ArrayList orgList)
    {
        System.out.println("���������� ���������� ������ �������� � ���������...");
        
        // start scanner
        //Scanner in = new Scanner(System.in);
        
        System.out.printf("������� ��� �����������:%n>>>");
        /*if (sc.hasNextLine())
        {
           String name = sc.nextLine();
           System.out.println("�������! �� ����� String " + name);
        }
        else 
        {
           System.out.println("��������, �� ��� ���� �� String. ������������� ��������� � ���������� �����!");
        }*/
        
        if (sc.next() == null)
        {
           System.out.println("�� ����� ����");
        }
        
        //String name = in.nextLine();
        //isNull(name);
        
        //System.out.printf("������� ��� �����������:%n>>>");
        //String coordinates = in.nextLine();
        return orgList;
    }
    public static void executeShow(ArrayList[] orgList)
    {
        //Object[] peopleArray = orgList.toArray();
        //for(Object person : peopleArray){
        //    System.out.println(person);
        //}
    }
    public static boolean isNull(Object variable)
    {
        if (null == variable) 
        {
            while(variable == null)
            {
                System.out.printf("Your input is null. Enter not-null value, please%n>>>");
                //String name = in.nextLine();
            }        
        }
    return false;
    }
}