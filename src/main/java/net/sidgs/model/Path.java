package net.sidgs.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by annapureddy on 1/23/2018.
 *uses list collections to store list of nodes.
 */
public class Path {

    List<Node> nodes=new LinkedList<Node>();
    Integer time;

    public Path(List<Node> nodes, Integer time) {
        this.nodes = nodes;
        this.time = time;
    }
    public Path() {
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String toString() {
        String result="";
        for(Node node : nodes){
            result+=node.getName().toUpperCase();
            result+=" ";
        }
        result=result + ": "+time;
        return result;
    }
}
