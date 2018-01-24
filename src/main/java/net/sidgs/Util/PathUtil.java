package net.sidgs.Util;

import net.sidgs.Model.Connection;
import net.sidgs.Model.Departure;
import net.sidgs.Model.Node;
import net.sidgs.Model.Path;

import java.util.*;

import static net.sidgs.Util.Data.conncetions;
import static net.sidgs.Util.Data.departures;

/**
 * Created by annap on 1/23/2018.
 */
public class PathUtil {

    List<Path> paths=new ArrayList<Path>();
    List<Path> successPath=new ArrayList<Path>();
    Path currentPath=new Path();
    public void findBestPath(String bageNumber, String fromGate, String flightId) {

        String toGate=null;
        if(flightId.equals("arrival"))
            toGate="baggageclaim";
        for(Departure departure: departures){
            if(departure.getFlightId().equals(flightId)) {
                toGate = departure.getFlightgate();
                break;
            }

        }
        printPaths(findRoutes(fromGate,toGate),bageNumber);
    }

    private Path findRoutes(String fromGate, String toGate) {

        List<Node> initialPath=new LinkedList<Node>();
        initialPath.add(new Node(fromGate));
        currentPath.setTime(0);
        currentPath.setNodes(initialPath);
        while(true) {
            Node currentPathNode = currentPath.getNodes().get(currentPath.getNodes().size() - 1);
            if (currentPathNode.getName().equals(toGate)) {
                successPath.add(currentPath);
                if (paths.size() > 0)
                    currentPath = paths.remove(0);
                else
                    break;
            } else {
                List<String> connections = getConnections(currentPathNode);
                removeBackwardConnections(connections);
                if(connections.size()==0) {
                    if (paths.size() > 0)
                        currentPath = paths.remove(0);
                    else
                        break;
                }
                else{
                    //creating and storing other possible paths
                    for(int i=1;i<connections.size();i++)
                        createPath(connections.get(i));
                    //updating current node
                    currentPath.getNodes().add(new Node(connections.get(0)));
                    int nodeToNodeTime= getTime(currentPathNode.getName(),connections.get(0));
                    currentPath.setTime(currentPath.getTime()+nodeToNodeTime);


                }
            }
        }
        return bestPath();

    }

    private Path bestPath() {
        int min=0;
        for(int i=0;i<successPath.size()-1;i++){
            Path nextPath=successPath.get(i+1);
            if(currentPath.getTime()>nextPath.getTime())
                min=i+1;
        }
        return successPath.get(min);
    }

    private int getTime(String currentPathNodeName, String newNodeName) {
        for(Connection connection: conncetions){
            if(connection.getNode1().equals(currentPathNodeName) && connection.getNode2().equals(newNodeName))
                return connection.getTime();
            if(connection.getNode2().equals(currentPathNodeName) && connection.getNode1().equals(newNodeName))
                return connection.getTime();

        }
        return 0;
    }

    private void printPaths(Path path, String bageNumber) {
            System.out.println(bageNumber+" "+path);
    }

    private void createPath(String s) {
        Path path= new Path();
        //copying object
        String name=null;
        for(Node node : currentPath.getNodes()){
            name=node.getName();
            path.getNodes().add(new Node(name));
        }
        int nodeToNodeTime=getTime(name,s);
        //adding new node to the path
        path.getNodes().add(new Node(s));
        path.setTime(currentPath.getTime()+nodeToNodeTime);
        paths.add(path);
    }

    private void removeBackwardConnections(List<String> connections) {

        for(Node node:currentPath.getNodes()){
            ListIterator<String> iterator=connections.listIterator();
            while(iterator.hasNext()){
                if(node.getName().equals(iterator.next()))
                    iterator.remove();
            }
        }
    }

    private List<String> getConnections(Node node) {

        List<String> result=new ArrayList<String>();
        for(Connection connection:conncetions){
            if(connection.getNode1().equals(node.getName()))
                result.add(connection.getNode2());
            if(connection.getNode2().equals(node.getName()))
                result.add(connection.getNode1());
        }
        return result;
    }
}
