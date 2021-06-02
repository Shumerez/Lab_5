import java.io.File;
import java.lang.Long;
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
    public static void fetchCommand()
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
               executeAdd();
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
        System.out.printf("help : вывести справку по доступным командам%ninfo : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)%nshow : вывести в стандартный поток вывода все элементы коллекции в строковом представлении%nadd {element} : добавить новый элемент в коллекцию%nupdate id {element} : обновить значение элемента коллекции, id которого равен заданному%nremove_by_id id : удалить элемент из коллекции по его id%nclear : очистить коллекцию%nsave : сохранить коллекцию в файл%nexecute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.%nexit : завершить программу (без сохранения в файл)%nremove_first : удалить первый элемент из коллекции%nremove_last : удалить последний элемент из коллекции%nshuffle : перемешать элементы коллекции в случайном порядке%ncount_by_postal_address postalAddress : вывести количество элементов, значение поля postalAddress которых равно заданному%nfilter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки%nprint_descending : вывести элементы коллекции в порядке убывания");
    }
    public static void executeAdd()
    {
        System.out.println("Инициируем добавление нового элемента в коллекцию...");
        // Generating ID
        System.out.println("Creating ID...");
        Integer id = 1 + FileManager.orgList.get(FileManager.orgList.size() - 1).getId(); //getting max+1 ID for new organization      
        System.out.println("ID created.");
        
        // Entering Name
        System.out.println("Creating NAME...");
        /*
        String name = "Error. You wasn't supposed to see this. Code 9011";
        do
        {
            System.out.printf("Введите имя организации:%n>>>");
            name = sc.nextLine();
            if  (isBlankString(name))
            {
                System.out.println("Your string is empty. Enter smth, please");
            }
        }
        while (isBlankString(name));
        System.out.println("Right name entered. It is non-empty string. Name = " + name);
        System.out.println("NAME created.");
        */
        // Entering Coordinates
        System.out.println("Creating COORDINATES...");
        System.out.printf("Введите координату x организации:%n>>>");
        
        while (!sc.hasNextLong()) 
        {
            System.out.println("You entered non-Long value. Try again, pls");
        }
        long x = sc.nextLong();
        
        System.out.printf("Введите координату y организации:%n>>>");
        while (!sc.hasNextLong()) 
        {
            System.out.println("You entered non-Long value. Try again, pls");
        }
        Long y = sc.nextLong();
        
        Coordinates coordinates = new Coordinates(x,y);
        System.out.println("COORDINATES created = " + x + " and " + y);
    }
    static boolean isBlankString(String string)
    {
        return string == null || string.trim().isEmpty();
    }
}