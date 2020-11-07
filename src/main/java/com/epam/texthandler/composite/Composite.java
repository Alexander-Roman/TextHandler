package com.epam.texthandler.composite;

import java.util.*;

public class Composite extends AbstractComponent {

    private final List<Component> children = new ArrayList<Component>();

    public Composite(Type type, List<Component> children) {
        super(type);
        this.children.addAll(children);
    }

    public List<Component> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public boolean hasChildren() {
        return true;
    }

    @Override
    public Iterator<Component> iterator() {
        return children.iterator();
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
        Composite composite = (Composite) o;
        return Objects.equals(children, composite.children);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + children.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "type=" + getType() +
                ", children=" + children +
                '}';
    }
}
