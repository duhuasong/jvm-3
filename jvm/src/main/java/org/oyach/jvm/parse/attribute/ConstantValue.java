package org.oyach.jvm.parse.attribute;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class ConstantValue extends Attribute {

    private final int valueIndex;

    public ConstantValue(int valueIndex) {
        super(AttributeType.CONSTANT_VALUE);
        this.valueIndex = valueIndex;
    }
}

