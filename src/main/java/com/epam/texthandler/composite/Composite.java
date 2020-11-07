package com.epam.texthandler.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Composite implements Component {

    private final List<Component> children = new ArrayList<Component>();

    public Composite(List<Component> children) {
        this.children.addAll(children);
    }

    @Override
    public List<Component> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Composite composite = (Composite) o;
        return Objects.equals(children, composite.children);
    }

    @Override
    public int hashCode() {
        return children.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "children=" + children +
                '}';
    }
}
