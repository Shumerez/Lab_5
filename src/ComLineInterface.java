import java.io.File;
import java.lang.Long;
import java.util.Scanner;
import java.util.ArrayList;
// for try-catch check on some commands
import java.util.InputMismatchException;

// experimenting with array output
import java.util.Arrays;




/**
 * Interpreting user input
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

class ComLineInterface
{
    public static Scanner sc = new Scanner(System.in);
    public static void readCommand()
    {
        System.out.print(">>>");
        
        do
        {
            
            String inputString = sc.nextLine();
            String command = new String();
        
            String[] inputArray = inputString.split(" ");
            command = inputArray[0];
            String[] arguments = new String[] {}; // must initialize 'arguments' variable out of if

            if (inputString.contains(" "))
            {
                
                arguments = Arrays.copyOfRange(inputArray, 1, inputArray.length); // if entered string contains space, count it's afterspace part as args
                //if (arguments == null)
            }            
            fetchCommand(command, arguments); 
            System.out.print(">>>");
        }
        while(sc.hasNextLine());
        
        sc.close(); // closing scanner
    }    
    public static void fetchCommand(String command, String[] arguments)
    {
        switch (command)
        {
            case ("help"):
                Command.executeHelp();
                System.out.printf("%n%n");
                break;
            case ("info"):
                Command.executeInfo();
                System.out.printf("%n%n");
                break;
            case ("show"):
                Command.executeShow();
                System.out.printf("%n%n");
                break;
            case ("add"):
                Command.executeAdd();
                System.out.printf("%n%n");
                break;
            case ("update"):
                try
                {
                    Command.executeUpdate(Integer.valueOf(arguments[0]));    
                }
                catch (NumberFormatException e) 
                {
                    System.out.printf("NumberFormatException occured. ID should be an integer. Enter command again.");
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.printf("(ArrayIndexOutOfBoundsException occured. No parameters found. Enter ID as a parameter with 'update' command.");
                }
                System.out.printf("%n%n");
                break;
            case ("remove_by_id"):
                try
                {
                    Command.executeRemoveById(Integer.valueOf(arguments[0]));
                }
                catch (NumberFormatException e) 
                {
                    System.out.printf("NumberFormatException occured. ID should be an integer. Enter command again.");
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.printf("(ArrayIndexOutOfBoundsException occured. No parameters found. Enter ID as a parameter with 'remove_by_id' command.");
                }
                System.out.printf("%n%n");
                break;
            case ("clear"):
                Command.executeClear();
                System.out.printf("%n%n");
                break;
            case ("save"):
                Command.executeSave();
                System.out.printf("%n%n");
                break;   
            case ("execute_script"):
                try
                {
                    Command.executeScript(arguments[0]);
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.printf("(ArrayIndexOutOfBoundsException occured. No parameters found. Enter postal address as a parameter with 'count_by_postal_address' command.");
                }
                System.out.printf("%n%n");
                break;
            case ("exit"):
                Command.executeExit();
                System.out.printf("%n%n");
                break;
            case ("remove_first"):
                Command.executeRemoveFirst();
                System.out.printf("%n%n");
                break;
            case ("remove_last"):
                Command.executeRemoveLast();
                System.out.printf("%n%n");
                break;
            case ("shuffle"):
                Command.executeShuffle();
                System.out.printf("%n%n");
                break;
            case ("count_by_postal_address"):
                try
                {
                    Command.executeCountByPostalAddress(arguments[0]);
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.printf("(ArrayIndexOutOfBoundsException occured. No parameters found. Enter postal address as a parameter with 'count_by_postal_address' command.");
                }
                System.out.printf("%n%n");
                break;
            case ("filter_starts_with_name"):
                try
                {
                    Command.executeFilterStartsWithName(arguments[0]);
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.printf("(ArrayIndexOutOfBoundsException occured. No parameters found. Enter any substring as a parameter with 'filter_starts_with_name' command.");
                }
                System.out.printf("%n%n");
                break;
            case ("print_descending"):
                Command.executePrintDescending();
                System.out.printf("%n%n");
                break;
            default:
                System.out.println("You entered some bullshit (" + command + "). Again, pls");
                break;
        }
    }
    static boolean isBlankString(String string)
    {
        return string == null || string.trim().isEmpty();
    }
}