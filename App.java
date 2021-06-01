import java.io.*;
import java.util.*;

/**
 * Main class. Runs program.
 */
public class App
{
    public App()
    {  
    }
    
    public static void main(String[] args) throws org.xml.sax.SAXException,IOException,javax.xml.parsers.ParserConfigurationException
    {
        ArrayList orgList = FileManager.readCollection();
        ComLineInterface.fetchCommand(orgList);
        //--------------ConsoleWaitingForInput();
        
        //ArrayList<Organization> OrgsList = new ArrayList<>();
        //Organization org1 = new Organization(Добавить_аргументы);
        //OrgsList.add(Org1);
    }
}
