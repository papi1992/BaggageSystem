package net.sidgs.controller;

import net.sidgs.error.InvalidCommandException;
import net.sidgs.model.Connection;
import net.sidgs.model.Departure;
import net.sidgs.model.Node;
import net.sidgs.services.ServiceFacade;
import net.sidgs.util.PathUtil;

import static net.sidgs.util.Data.conncetions;
import static net.sidgs.util.Data.departures;
import static net.sidgs.util.Data.nodes;

/**
 * Created by annapureddy
 * it takes sample data from console
 */
public class ProcessCommand {

    ServiceFacade serviceFacade = new ServiceFacade();

    /**
     * @param command
     * @return
     * @throws InvalidCommandException take input and spliting  sections based upon # section
     *                                 if sample data does't  match requirment it will say invalid command
     *                                 validates tokens and store it in corresponding collections like departures, connections and nodes
     */

    public boolean execute(String command) throws InvalidCommandException {
        if (command == null) {
            return false;
        } else {

            command = command.toLowerCase();
            String[] tokens = command.split(" ");
            if (tokens.length < 3) throw new InvalidCommandException("Invalid Command : Has invalid number of tokens");
            else {
                if (command.contains("#")) {
                    if (command.contains("conveyor"))
                        StatusFlag.STATUS = StatusFlag.status.CONVSYSTEM;
                    else if (command.contains("departures"))
                        StatusFlag.STATUS = StatusFlag.status.DEPARTURES;
                    else if (command.contains("bags"))
                        StatusFlag.STATUS = StatusFlag.status.BAGS;
                    else throw new InvalidCommandException("");
                } else {
                    if (StatusFlag.STATUS == StatusFlag.status.CONVSYSTEM) {
                        if (tokens.length != 3)
                            throw new InvalidCommandException("Inavlid command : try <Node 1> <Node 2> <travel_time>");
                        serviceFacade.insertNode(tokens[0]);
                        serviceFacade.insertNode(tokens[1]);
                        serviceFacade.createConnection(tokens[0], tokens[1], tokens[2]);
                    } else if (StatusFlag.STATUS == StatusFlag.status.DEPARTURES) {
                        if (tokens.length != 4)
                            throw new InvalidCommandException("Inavlid command : try <flight_id> <flight_gate> <destination> <flight_time>");
                        serviceFacade.insertDeparture(tokens);

                    } else {
                        if (tokens.length != 3)
                            throw new InvalidCommandException("Inavlid command : try <bag_number> <entry_point> <flight_id>");
                        PathUtil pathUtil = new PathUtil();
                        pathUtil.findBestPath(tokens[0], tokens[1], tokens[2]);
                    }

                }


            }

        }
        return true;
    }

}
