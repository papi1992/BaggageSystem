package net.sidgs;

import net.sidgs.Error.InvalidCommandException;
import net.sidgs.Util.ProcessCommand;

import java.util.Scanner;

/**
 * Hello world!
 *takes sample data through scanner and ProcessCommand class process will process that data
 *
 */
public class BaggageSystem
{
    public static void main( String[] args )
    {
        System.out.println("Enter the Input");
        Scanner scanner= new Scanner(System.in);
        ProcessCommand processCommand=new ProcessCommand();
        String temp;
        while(true){
            temp=scanner.nextLine();
            try {
                processCommand.execute(temp);
            } catch (InvalidCommandException e) {
                System.out.println("Illegal arguments or inputs. Please refer to readme for the input data format.");
            }
        }
    }
}
