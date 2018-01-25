package net.sidgs.Util;

import net.sidgs.Error.InvalidCommandException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

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
