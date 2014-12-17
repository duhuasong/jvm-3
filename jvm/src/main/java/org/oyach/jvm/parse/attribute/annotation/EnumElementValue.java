package org.oyach.jvm.parse.attribute.annotation;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class EnumElementValue extends ElementValue {

    private final int enumTypeNameIndex;

    private final int constantNameIndex;

    protected EnumElementValue(char tag, int enumTypeNameIndex, int constantNameIndex) {
        super(tag);
        this.enumTypeNameIndex = enumTypeNameIndex;
        this.constantNameIndex = constantNameIndex;
    }
}
