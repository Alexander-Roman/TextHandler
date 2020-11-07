package com.epam.texthandler.logic;

import com.epam.texthandler.composite.Component;

public interface TextManipulator {

    Component resolveMathExpressions(Component component);

    String restoreText(Component text);

    Component sortParagraphs(Component text);

    Component sortWordsInAllSentences(Component text);
}
