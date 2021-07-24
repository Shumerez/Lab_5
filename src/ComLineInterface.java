import java.io.File;
import java.lang.Long;
import java.util.Scanner;
import java.util.ArrayList;
// перенести в Commands класс, когда будешь переносить реализацию команд
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
// for filtering
import java.util.function.Predicate;
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
        String[] arguments = new String[] {}; // must initialize 'arguments' variable out of if
        
        if (inputString.contains(" "))
        {
            arguments = Arrays.copyOfRange(inputArray, 1, inputArray.length); // if entered string contains space, count it's afterspace part as args
        }
        switch (command) {
            case ("help"):
               executeHelp();
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("info"):
               executeInfo();
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
               // executeUpdate();
               System.out.printf("%n%n");
               fetchCommand();
               break;
            case ("remove_by_id"): // in progress
               executeRemoveById(Integer.valueOf(arguments[0]));
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
               executeExit();
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
               executeShuffle();
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
        System.out.printf("help : вывести справку по доступным командам%ninfo : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)%nshow : вывести в стандартный поток вывода все элементы коллекции в строковом представлении%nadd {element} : добавить новый элемент в коллекцию%nupdate id {element} : обновить значение элемента коллекции, id которого равен заданному%nremove_by_id id : удалить элемент из коллекции по его id%nclear : очистить коллекцию%nsave : сохранить коллекцию в файл%nexecute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.%nexit : завершить программу (без сохранения в файл)%nremove_first : удалить первый элемент из коллекции%nremove_last : удалить последний элемент из коллекции%nshuffle : перемешать элементы коллекции в случайном порядке%ncount_by_postal_address postalAddress : вывести количество элементов, значение поля postalAddress которых равно заданному%nfilter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки%nprint_descending : вывести элементы коллекции в порядке убывания");
    }
    public static void executeInfo()
    {
        System.out.printf("Array type: List;%nArray creation date: " + FileManager.creationDate + ";%nArray size: " + FileManager.orgList.size() + ";");
    }
    public static void executeShow()
    {
        System.out.println(FileManager.orgList);
    }
    public static void executeAdd()
    {
        System.out.println("Инициируем добавление нового элемента в коллекцию...");
        
        // Generating ID id (ok)
        System.out.println("Creatwing ID...");
        Integer id = 1 + FileManager.maxId;
        FileManager.maxId += 1;
        System.out.println("ID created.");
        
        // Entering Name name (ok)
        System.out.println("Creating Name...");
        
        String name;
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
        
       
        // Entering Coordinates coordinates (ok)
        Coordinates coordinates = new Coordinates(sc);
        
        // working on DATE date (ok)
        System.out.println("Creating creationDate...");
        System.out.printf("Введите дату создания:%n>>>");
        
        sc.nextLine(); // clear buffer
        
        String str = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date = LocalDateTime.parse(str, formatter);
        System.out.println("creationDate created = " + date);
        
        
        // working on annualTurnover turnover (ok)
        System.out.println("Creating annualTurnover...");
        System.out.printf("Введите ежегодный оборот:%n>>>");
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
        System.out.println("ID of the third element: " + FileManager.orgList.get(2).getId());
        System.out.println("ID of needed element: " + id);
        
        Predicate<Organization> filter = (organization) -> { return (organization.getId() == id); };
        // Predicate<Organization> filter = (organization) -> { return true; };
        // Predicate<Organization> filter = (organization) -> { System.out.println(organization.getId()); return false;};
        
        try
        {
            System.out.println(FileManager.orgList.removeIf(filter));
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Array is already empty!");
        }
    }
    public static void executeClear()
    {
        FileManager.orgList.clear();
        System.out.println("Array cleared");
    }
    public static void executeExit()
    {
        System.exit(0);
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
            System.out.println("Last element removed. It's id was: " + (FileManager.orgList.size() + 1));
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Array is already empty!");
        }
    }
    public static void executeShuffle()
    {
        Collections.shuffle(FileManager.orgList);
        System.out.println(FileManager.orgList);
    }
    public static void executePrintDescending()
    {
        // Использует компараторы,     
        /*
        Comparator<Organization> idComparator = (o1, o2) -> o1.getId().compareTo(o2.getId()); // override compareTo method 
                                                                                              // for our Organization class
        FileManager.orgList.sort(idComparator.reversed()); // sort in reverse
        
        System.out.println(FileManager.orgList); // print sorted in reverse
        
        FileManager.orgList.sort(idComparator); // sort to the normal state

        /* Альтернативный подход - без компараторов, сортирует в порядке, обратном имеющемуся
         *  Collections.reverse(FileManager.orgList);
         *  System.out.println(FileManager.orgList);
         *  Collections.reverse(FileManager.orgList);
         *  System.out.println(FileManager.orgList);
         */
        
        // Текущий подход - сортирует по "убыванию" (descending). Так как compareTo переопределен у меня
        // как сравнение id, сортирует по убыванию id. Не использует компараторы.
        
        ArrayList<Organization> sortList = new ArrayList<>(FileManager.orgList); // create copy
        sortList.sort(Collections.reverseOrder()); // sort in reverse
        System.out.println(sortList); // print sorted in reverse
        sortList = null; // clear memory
    }
    static boolean isBlankString(String string)
    {
        return string == null || string.trim().isEmpty();
    }
}