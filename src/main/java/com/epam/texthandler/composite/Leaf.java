package com.epam.texthandler.composite;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Leaf implements Component {

    private final Type type;
    private final String value;

    private Leaf(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    public static Leaf wordFrom(String value) {
        return new Leaf(Type.WORD, value);
    }

    public static Leaf mathFrom(String value) {
        return new Leaf(Type.MATH, value);
    }

    public Type getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public List<Component> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Leaf leaf = (Leaf) o;
        return type == leaf.type &&
                Objects.equals(value, leaf.value);
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}