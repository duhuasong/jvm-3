package org.oyach.jvm.parse.attribute;

import java.util.List;

import static java.util.Collections.unmodifiableList;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class LineNumberTable extends Attribute {

    private final List<LineNumber> lineNumbers;

    protected LineNumberTable(List<LineNumber> lineNumbers) {
        super(AttributeType.LINE_NUMBER_TABLE);
        this.lineNumbers = unmodifiableList(lineNumbers);
    }

    public List<LineNumber> getLineNumbers() {
        return lineNumbers;
    }
}
