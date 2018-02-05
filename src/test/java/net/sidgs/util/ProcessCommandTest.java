package net.sidgs.util;

import net.sidgs.controller.ProcessCommand;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;

/**
 * Created by annap on 1/24/2018.
 */
public class ProcessCommandTest {
    ProcessCommand processCommand =new ProcessCommand();


     @Test
     public void testExecute() throws Exception{

        boolean result =processCommand.execute("# section Bags");
        Assert.assertEquals(true,result);

     }

}
