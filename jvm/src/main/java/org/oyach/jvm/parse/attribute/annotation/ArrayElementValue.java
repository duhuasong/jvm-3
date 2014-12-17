package org.oyach.jvm.parse.attribute.annotation;

import java.util.List;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class ArrayElementValue extends ElementValue {

    private final List<ElementValue> values;

    protected ArrayElementValue(char tag, List<ElementValue> values) {
        super(tag);
        this.values = values;
    }
}
