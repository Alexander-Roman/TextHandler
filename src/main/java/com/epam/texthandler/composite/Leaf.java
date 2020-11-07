package com.epam.texthandler.composite;

import java.util.Iterator;
import java.util.Objects;

public class Leaf extends AbstractComponent {

    private final String value;

    public Leaf(Type type, String value) {
        super(type);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public Iterator<Component> iterator() {
        return new Itr();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Leaf leaf = (Leaf) o;
        return Objects.equals(value, leaf.value);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "type=" + getType() +
                ", value='" + value + '\'' +
                '}';
    }

    public class Itr implements Iterator<Component> {

        private boolean hasNext = true;

        @Override
        public boolean hasNext() {
            return hasNext;
        }

        @Override
        public Leaf next() {
            hasNext = false;
            return Leaf.this;
        }
    }
}