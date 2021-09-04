import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;
// experimenting with array output
import java.util.Arrays;
// for creationData var
import java.util.Date;
/**
 * Reads collection from a file.
 * @return Readed collection.
 */



public class FileManager {
    static public ArrayList<Organization> orgList = new ArrayList<>();
    static public Integer maxId = 0; // this var needed for generating unique IDs in future
    static public Date creationDate = new Date(); // collection's creation date
    
    public static ArrayList readCollection() throws ParserConfigurationException, IOException, org.xml.sax.SAXException 
    {
        // Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
         
        // Build Document
        Document document = builder.parse(new File("C:/bin/JavaProjects/Lab_5/Organizations.xml"));
         
        // Normalize the XML Structure
        document.getDocumentElement().normalize();
         
        // Here comes the root node
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());
         
        // Get all organizations
        NodeList nList = document.getElementsByTagName("organization");
        System.out.println("============================");
        
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            System.out.println("");    // Just a separator
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                // Print each organization's detail
                Element eElement = (Element) node;
                
                
                // System.out.println("Organisation id : "    + eElement.getAttribute("id"));
                Integer id = new Integer(eElement.getAttribute("id"));
                
                // System.out.println("Name : "  + eElement.getElementsByTagName("name").item(0).getTextContent());
                String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                
                // System.out.println("Coordinates : "   + eElement.getElementsByTagName("coordinates").item(0).getTextContent());
                String phrase = eElement.getElementsByTagName("coordinates").item(0).getTextContent(); //parsing coordinates to get separated x and yy
                String delims = ", ";
                String[] tokens = phrase.split(delims);
                
                long x = Long.valueOf(tokens[0]);
                Long y = Long.valueOf(tokens[1]); // not null
                Coordinates coordinates = new Coordinates(x, y);
                
                // System.out.println("Creation date : "    + eElement.getElementsByTagName("creationDate").item(0).getTextContent());
                String str = eElement.getElementsByTagName("creationDate").item(0).getTextContent();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                LocalDateTime creationDate = LocalDateTime.parse(str, formatter);
    
                // System.out.println("Annual turnover : "   + eElement.getElementsByTagName("annualTurnover").item(0).getTextContent());
                Integer annualTurnover = new Integer(eElement.getElementsByTagName("annualTurnover").item(0).getTextContent());
                
                // System.out.println("Type : "    + eElement.getElementsByTagName("type").item(0).getTextContent());
                OrganizationType type = OrganizationType.valueOf(eElement.getElementsByTagName("type").item(0).getTextContent());
                
                // System.out.println("Postal address : "    + eElement.getElementsByTagName("postalAddress").item(0).getTextContent());
                Address address = new Address(eElement.getElementsByTagName("postalAddress").item(0).getTextContent());
                
                Organization org = new Organization(id, name, coordinates, creationDate, annualTurnover, type, address);
                orgList.add(org);
                
                // also we should find max ID here, to be sure that they will be unique in future
                if (id > maxId) {maxId = id;}
            }
        }
        creationDate = new Date();
        return orgList;
    }   
}