package org.oyach.jvm.parse.attribute;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class EnclosingMethod extends Attribute {

    private final int classIndex;

    private final int methodIndex;

    protected EnclosingMethod(int classIndex, int methodIndex) {
        super(AttributeType.ENCLOSING_METHOD);
        this.classIndex = classIndex;
        this.methodIndex = methodIndex;
    }
}