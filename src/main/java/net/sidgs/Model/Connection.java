package net.sidgs.Model;

/**
 * Created by annap on 1/23/2018.
 */
public class Connection {
    String node1;
    String node2;
    Integer time;


    public Connection(String node1, String node2, Integer time) {
        this.node1 = node1;
        this.node2 = node2;
        this.time = time;
    }

    public Connection() {
    }

    public String getNode1() {
        return node1;
    }

    public void setNode1(String node1) {
        //TODO eleminate duplicate connections
        this.node1 = node1;
    }

    public String getNode2() {
        return node2;
    }

    public void setNode2(String node2) {
        this.node2 = node2;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "node1='" + node1 + '\'' +
                ", node2='" + node2 + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Connection that=(Connection) o;
        if(this.node1.equals(that.node1))
            if(this.node2.equals(that.node2))
                return true;
        if(this.node1.equals(that.node2))
            if(this.node2.equals(that.node1))
                return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result = node1.hashCode();
        result = result + node2.hashCode();
        return result;
    }
}
