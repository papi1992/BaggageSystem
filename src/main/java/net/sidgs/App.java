package net.sidgs;

import net.sidgs.Error.InvalidCommandException;
import net.sidgs.Util.ProcessCommand;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
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
                System.out.println(e.getMessage());
            }

        }
    }
}
