import java.io.*;
import java.util.*;

/**
 * Main class. Runs program.
 */
public class Main
{
    public Main() {}
    
    public static void main(String[] args) throws org.xml.sax.SAXException,IOException,javax.xml.parsers.ParserConfigurationException
    {
        ArrayList orgList = FileManager.readCollection();
        ComLineInterface.readCommand();
    }
}
