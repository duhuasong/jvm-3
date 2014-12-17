package org.oyach.jvm.parse.attribute;

import java.util.List;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class InnerClass extends Attribute {

    private final List<InnerClassDetails> icds;

    public InnerClass(List<InnerClassDetails> icds) {
        super(AttributeType.INNER_CLASSES);
        this.icds = icds;
    }
}