package org.oyach.jvm.parse;

import org.oyach.jvm.parse.attribute.Attribute;
import org.oyach.jvm.parse.attribute.AttributeType;

import java.util.EnumMap;
import java.util.Map;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class Attributes {

    private final Map<AttributeType, Attribute> attributes = new EnumMap<>(AttributeType.class);

    public Attributes(Iterable<Attribute> attributes) {
        for (Attribute attribute : attributes) {
            if (attribute != null) {
                this.attributes.put(attribute.getType(), attribute);
            }
        }
    }

    public Attribute getAttribute(AttributeType type) {
        return attributes.get(type);
    }
}
