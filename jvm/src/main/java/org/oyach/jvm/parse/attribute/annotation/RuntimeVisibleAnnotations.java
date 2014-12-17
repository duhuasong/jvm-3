package org.oyach.jvm.parse.attribute.annotation;



import org.oyach.jvm.parse.attribute.AttributeType;

import java.util.List;

public class RuntimeVisibleAnnotations extends Annotations {

    public RuntimeVisibleAnnotations(List<Annotation> annotations) {
        super(AttributeType.RUNTIME_VISIBLE_ANNOTATIONS, annotations);
    }
}
