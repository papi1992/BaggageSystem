package net.sidgs.Model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by annap on 1/23/2018.
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
        return "Path{" +
                "nodes=" + nodes +
                ", time=" + time +
                '}';
    }
}
