package org.oyach.jvm.parse.attribute.annotation;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class ConstantElementValue extends ElementValue {

    private final int constantValueIndex;

    protected ConstantElementValue(char tag, int constantValueIndex) {
        super(tag);
        this.constantValueIndex = constantValueIndex;
    }
}
