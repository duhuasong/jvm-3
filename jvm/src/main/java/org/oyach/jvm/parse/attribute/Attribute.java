package org.oyach.jvm.parse.attribute;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public abstract class Attribute {
    private final AttributeType type;

    protected Attribute(AttributeType type) {
        this.type = type;
    }

    public AttributeType getType() {
        return type;
    }
}
