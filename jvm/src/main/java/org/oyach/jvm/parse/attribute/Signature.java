package org.oyach.jvm.parse.attribute;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class Signature extends Attribute {

    private final int signatureIndex;

    protected Signature(int signatureIndex) {
        super(AttributeType.SIGNATURE);
        this.signatureIndex = signatureIndex;
    }
}

