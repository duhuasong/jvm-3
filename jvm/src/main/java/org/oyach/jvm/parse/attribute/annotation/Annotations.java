package org.oyach.jvm.parse.attribute.annotation;


import org.oyach.jvm.parse.attribute.Attribute;
import org.oyach.jvm.parse.attribute.AttributeType;

import java.util.List;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public abstract class Annotations extends Attribute {

    private final List<Annotation> annotations;

    public Annotations(AttributeType type, List<Annotation> annotations) {
        super(type);
        this.annotations = annotations;
    }
}
