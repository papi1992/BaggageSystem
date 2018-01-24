package net.sidgs.Util;

import net.sidgs.Model.Departure;

import static net.sidgs.Util.Data.departures;

/**
 * Created by annap on 1/23/2018.
 */
public class PathUtil {
    
    public void findBestPath(String bageNumber, String fromGate, String flightId) {

        String toGate=null;
        for(Departure departure: departures){
            if(departure.getFlightId().equals(flightId))
                toGate=departure.getFlightgate();
        }
        findRoutes(fromGate,toGate);
    }

    private void findRoutes(String fromGate, String toGate) {



    }
}
