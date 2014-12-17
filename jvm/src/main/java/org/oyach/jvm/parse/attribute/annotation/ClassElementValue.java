package org.oyach.jvm.parse.attribute.annotation;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class ClassElementValue extends ElementValue {

    private final int classInfoIndex;

    protected ClassElementValue(char tag, int classInfoIndex) {
        super(tag);
        this.classInfoIndex = classInfoIndex;
    }
}
