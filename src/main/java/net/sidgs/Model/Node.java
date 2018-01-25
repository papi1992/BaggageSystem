package net.sidgs.Model;

/**
 * Created by annapuredy on 1/23/2018.
 * simple class for node
 */
public class Node {
    String name;

    public Node(String name) {
        this.name = name;
    }

    public Node() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return this.name.equals(node.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
