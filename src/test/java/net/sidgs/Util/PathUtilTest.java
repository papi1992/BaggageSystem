package net.sidgs.Util;

import net.sidgs.Model.Departure;
import net.sidgs.Model.Path;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by annap on 1/24/2018.
 */
public class PathUtilTest {

    String bageNumber = "v123";
    String fromGate = "A2";
    String flightId = "U123";
    String bag = "BaggageCliam";
    Path path;
    Departure departure;
    Set<Departure> mock;


    @Before
    public void setUp() {
        path = Mockito.mock(Path.class);
        departure = Mockito.mock(Departure.class);

    }

    @Test
    public void findBestPathTest() {

        Mockito.when(departure.getFlightId()).thenReturn(flightId);
        Mockito.when(departure.getFlightgate()).thenReturn(fromGate);

    }
}
