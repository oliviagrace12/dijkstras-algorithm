package main.java;

import java.util.Objects;

/**
 * Created by oliviachisman on 11/12/18
 */
public class Node implements Comparable {

    private Character c;
    private Integer value;

    public Node(Character c, Integer weight) {
        this.c = c;
        this.value = weight;
    }

    public Character getC() {
        return c;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "c=" + c +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return value == node.value &&
                Objects.equals(c, node.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(c, value);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Node) {
            return value.compareTo(((Node) o).getValue());
        } else {
            throw new ClassCastException();
        }
    }
}
