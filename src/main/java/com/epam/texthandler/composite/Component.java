package com.epam.texthandler.composite;

public interface Component extends Iterable<Component> {

    Type getType();

    boolean hasChildren();

}
