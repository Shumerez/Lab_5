/**
 * Enumeration OrganizationType - contains information about Organization class
 */
import java.util.Scanner;
public enum OrganizationType
{
    COMMERCIAL,
    GOVERNMENT,
    PRIVATE_LIMITED_COMPANY
    ;
    String description;
    
    static OrganizationType chooseType(Scanner sc)
    {
        // Scanner sc = new Scanner(System.in);
        System.out.println("Creating OrganizationType...");
        for (OrganizationType orgtype : OrganizationType.values()) {  // shows all orgtypes
            System.out.println(orgtype); 
        }
        System.out.printf("Выберите тип организации:%n>>>");
        
        OrganizationType type = null;
        
        boolean inputIsRight = false;
        
        sc.nextLine(); // clear buffer
        while (!inputIsRight)
        {
            String whichOrg = sc.nextLine().toUpperCase();
            switch (whichOrg)
            {
                case ("COMMERCIAL"):
                    inputIsRight = true;
                    type = OrganizationType.COMMERCIAL;
                    break;
                case ("GOVERNMENT"):
                    inputIsRight = true;
                    type = OrganizationType.GOVERNMENT;
                    break;
                case ("PRIVATE_LIMITED_COMPANY"):
                    inputIsRight = true;
                    type = OrganizationType.PRIVATE_LIMITED_COMPANY;
                    break;
                default:
                    System.out.printf("Wrong organization type entered, try again%n>>>");
                    break;
            }
        }
        System.out.println("OrganizationType created = " + type);
        return type;
    }
}


