import java.util.ArrayList;
import java.util.Scanner;
// перенести в Commands класс, когда будешь переносить реализацию команд
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
// for sort operations
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
// for execute_ComLineInterface.script command
import java.io.File;
import java.io.FileNotFoundException;
// only for SAVE command, remove to a Commands class after command repostition
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
// for filtering
import java.util.function.Predicate;
// experimenting with array output
import java.util.Arrays;
// import InputMismatchException for try-catch checks of user input
import java.util.InputMismatchException;
public class Command
{
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
    public static void executeAdd() // user input is done
    {
        System.out.println("Инициируем добавление нового элемента в коллекцию...");
        
        // ID is done
        System.out.println("Creating ID...");
        Integer id = 1 + FileManager.maxId;
        FileManager.maxId += 1;
        System.out.println("ID created.");
        
        // Name is done
        System.out.println("Creating Name...");
        
        String name;
        do
        {
            System.out.printf("Введите имя организации:%n>>>");
            name = ComLineInterface.sc.nextLine();
            if  (ComLineInterface.isBlankString(name))
            {
                System.out.println("Your string is empty. Enter smth, please");
            }
        }
        while (ComLineInterface.isBlankString(name));
        System.out.println("Right name entered. It is non-empty string. Name = " + name);
        
        System.out.println("NAME created.");
        
       
        // Coordinates is done
        Coordinates coordinates = new Coordinates(ComLineInterface.sc);
        
        // Date is done
        System.out.println("Creating creationDate...");
        System.out.printf("Введите дату создания:%n>>>");
        
        ComLineInterface.sc.nextLine(); // clear buffer
        
        boolean inputIsRight; // flag for input check
        LocalDateTime date = null; // default value of variable 'date'
        do
        {
            inputIsRight = true; // initial flag is true - if no errors, 'do' cycle will end successfuly
            
            try
            {
                String str = ComLineInterface.sc.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                date = LocalDateTime.parse(str, formatter);
                System.out.println("creationDate created = " + date);
            }
            catch (DateTimeParseException e) { System.out.printf("DateTimeParseException occured. Enter date again, in format 'yyyy-mm-dd hh:mm', 24 hours%n>>>"); inputIsRight = false; } // error - show message, set flag false, clear scanner buffer
        }
        while (!inputIsRight); // checking flag

        // Annual turnover is done
        System.out.println("Creating annualTurnover...");
        System.out.printf("Введите ежегодный оборот:%n>>>");
        
        Integer turnover = null; // default value of variable 'turnover'
        do
        {
            inputIsRight = true; // initial flag is true - if no errors, 'do' cycle will end successfuly
            
            try
            {
                turnover = ComLineInterface.sc.nextInt(); 
                System.out.println("annualTurnover created = " + turnover);
            }
            catch (InputMismatchException e) { System.out.printf("InputMismatchException occured. Enter annual turnover again, it should be integer%n>>>"); inputIsRight = false; ComLineInterface.sc.nextLine(); } // error - show message, set flag false, clear scanner buffer
        }
        while (!inputIsRight); // checking flag
        
        // Organization type is done
        OrganizationType type = OrganizationType.chooseType(ComLineInterface.sc);
       
        // Postal address is done
        Address address = new Address(ComLineInterface.sc);
        
        Organization org = new Organization( id, name, coordinates, date, turnover, type, address );
        FileManager.orgList.add(org);
        
        System.out.println(FileManager.orgList);
    }
    public static void executeUpdate(Integer id)
    {
        boolean suchIdExist = false;
        for(Organization iterateOrg : FileManager.orgList) { 
            if (iterateOrg.getId().equals(id)) 
            { 
                System.out.println("Such ID exist.");
                suchIdExist = true;
                
                System.out.println("Изменяем поля существующего элемента коллекции");
                // Organization org = FileManager.orgList.get(id - 1);
                
                // Name is done
                System.out.println("Updating Name...");
                
                String name;
                do
                {
                    System.out.printf("Введите имя организации:%n>>>");
                    name = ComLineInterface.sc.nextLine();
                    if  (ComLineInterface.isBlankString(name))
                    {
                        System.out.println("Your string is empty. Enter smth, please");
                    }
                }
                while (ComLineInterface.isBlankString(name));
                System.out.println("Right name entered. It is non-empty string. Name = " + name);
                
                System.out.println("Name updated.");
                
               
                // Coordinates is done
                Coordinates coordinates = new Coordinates(ComLineInterface.sc);
                
                // Date is done
                System.out.println("Updating creationDate...");
                System.out.printf("Введите дату создания:%n>>>");
                
                ComLineInterface.sc.nextLine(); // clear buffer
                
                boolean inputIsRight; // flag for input check
                LocalDateTime date = null; // default value of variable 'date'
                do
                {
                    inputIsRight = true; // initial flag is true - if no errors, 'do' cycle will end successfuly
                    try
                    {   
                        String str = ComLineInterface.sc.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                        date = LocalDateTime.parse(str, formatter);
                        System.out.println("creationDate created = " + date);
                    }
                    catch (DateTimeParseException e) 
                    {
                        System.out.printf("DateTimeParseException occured. Enter date again, in format 'yyyy-mm-dd hh:mm', 24 hours%n>>>");
                        inputIsRight = false;
                    } // error - show message, set flag false, clear scanner buffer
                }
                while (!inputIsRight); // checking flag
                
                // Annual turnover is done
                System.out.println("Updating annualTurnover...");
                System.out.printf("Введите ежегодный оборот:%n>>>");
                        
                Integer turnover = null; // default value of variable 'turnover'
                do
                {
                    inputIsRight = true; // initial flag is true - if no errors, 'do' cycle will end successfuly
                    
                    try
                    {
                        turnover = ComLineInterface.sc.nextInt();
                        System.out.println("annualTurnover updated = " + turnover);
                    }
                    catch (InputMismatchException e) { System.out.printf("InputMismatchException occured. Enter annual turnover again, it should be integer%n>>>"); inputIsRight = false; ComLineInterface.sc.nextLine(); } // error - show message, set flag false, clear scanner buffer
                }
                while (!inputIsRight); // checking flag
                
                // Organization type is done
                OrganizationType type = OrganizationType.chooseType(ComLineInterface.sc);
               
                // Postal address is done
                Address address = new Address(ComLineInterface.sc);
                
                Organization org = new Organization(id, name, coordinates, date, turnover, type, address);
                FileManager.orgList.set(id - 1, org);
                
                System.out.println(FileManager.orgList);   
            }
        }
        if (suchIdExist == false)
        {
            System.out.println("Such element doesn't exist.");
        }
    }
    public static void executeRemoveById(Integer id) {
        Predicate<Organization> filter = (organization) -> { return (Integer.valueOf(organization.getId()) == Integer.valueOf(id)); };       
        
        if ( !FileManager.orgList.removeIf(filter) ) { System.out.println("Such element doesn't exist."); }
        else { System.out.println("Element with id = " + id + " removed successfully."); }
    }
    public static void executeClear()
    {
        FileManager.orgList.clear();
        System.out.println("Array cleared");
    }
    public static void executeSave()
    {
    String xmlFilePath = "C:/bin/Git/Lab_5/xmls/OrganizationsSave.xml"; // for windows
    // Document document = builder.parse(new File(System.getenv("orgSavePath"))); for helios

    try
    {    
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            
            // root element
            Element root = document.createElement("organizationsList");
            document.appendChild(root);
            
            for (Organization org : FileManager.orgList)
            { 
                // organisation element
                Element organisation = document.createElement("organization");
                root.appendChild(organisation);
           
                // set an attribute to staff element
                Attr attr = document.createAttribute("id");
                attr.setValue(org.getId().toString());
                organisation.setAttributeNode(attr);
           
            
                // name element
                Element name = document.createElement("name");
                name.appendChild(document.createTextNode(org.getName()));
                organisation.appendChild(name);
                
                // coordinates element
                Element coordinates = document.createElement("coordinates");
                coordinates.appendChild(document.createTextNode(org.getCoordinates().toString()));
                organisation.appendChild(coordinates);
                
                // creationDate element
                Element creationDate = document.createElement("creationDate");
                creationDate.appendChild(document.createTextNode(org.getCreationDate().toString()));
                organisation.appendChild(creationDate);
                
                // annualTurnover element
                Element annualTurnover = document.createElement("annualTurnover");
                annualTurnover.appendChild(document.createTextNode(org.getAnnualTurnover().toString()));
                organisation.appendChild(annualTurnover);
                
                // type element
                Element type = document.createElement("type");
                type.appendChild(document.createTextNode(org.getType().toString()));
                organisation.appendChild(type);
                
                // postalAddress element
                Element postalAddress = document.createElement("postalAddress");
                postalAddress.appendChild(document.createTextNode(org.getPostalAddress().toString()));
                organisation.appendChild(postalAddress);
            }
            
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
            
            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging 
            
            transformer.transform(domSource, streamResult);
            
            System.out.println("Done creating XML File");
        
    } catch (ParserConfigurationException pce) {
        pce.printStackTrace();
    } catch (TransformerException tfe) {
        tfe.printStackTrace();
    }
    }
    public static void executeScript(String fileName)
    {
    
        // creating File instance to reference text file in Java
        File text = new File(fileName); // C:\bin\JavaProjects\Lab_5\Script.txt
        boolean fileExists = true;
        //Creating ComLineInterface.scanner instance to read File in Java
        try
        {
            ComLineInterface.sc = new Scanner(text);
        } 
        catch(FileNotFoundException c) 
        {
            System.out.printf("Файл не найден");
            fileExists = false; // file is not exists, we must not do other part of command
        }
        
        // ComLineInterface.sc = new ComLineInterface.scanner(text);
        // Reading each line of the file using ComLineInterface.scanner class
        if (fileExists)
        {
            while (ComLineInterface.sc.hasNextLine() && fileExists)
            {
                String inputString = ComLineInterface.sc.nextLine();
                String command = new String();
                
                String[] inputArray = inputString.split(" ");
                command = inputArray[0];
                String[] arguments = new String[] {}; // must initialize 'arguments' variable out of if
        
                if (inputString.contains(" "))
                {
                    arguments = Arrays.copyOfRange(inputArray, 1, inputArray.length); // if entered string contains space, count it's afterspace part as args
                }
                ComLineInterface.fetchCommand(command, arguments);
            }
            ComLineInterface.sc = new Scanner(System.in);
        }
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
    public static void executeCountByPostalAddress(String address)
    {
        Integer addrCount = 0;
        for (Organization org : FileManager.orgList) {
            if ( org.getPostalAddress().toString().equals(address) ) { addrCount += 1;}
        }
        System.out.printf("%nThere are " + addrCount + " organisations with this postal address.");
    }
    public static void executeFilterStartsWithName(String substring)
    {
        ArrayList<Organization> filterList = new ArrayList<>(); // create empty list
        for (Organization org : FileManager.orgList) {
            if ( org.getName().toString().startsWith(substring) ) { filterList.add(org);}
        }
        System.out.println(filterList);
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
        
        // Текущий подход - сортирует по "убыванию" (deComLineInterface.scending). Так как compareTo переопределен у меня
        // как сравнение id, сортирует по убыванию id. Не использует компараторы.
        
        ArrayList<Organization> sortList = new ArrayList<>(FileManager.orgList); // create copy
        sortList.sort(Collections.reverseOrder()); // sort in reverse
        System.out.println(sortList); // print sorted in reverse
        sortList = null; // clear memory
    }
}
