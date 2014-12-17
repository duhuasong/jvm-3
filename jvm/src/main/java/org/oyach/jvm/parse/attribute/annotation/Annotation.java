package org.oyach.jvm.parse.attribute.annotation;

import org.oyach.jvm.parse.Parser;

import java.util.List;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class Annotation {
    public static final Parser<Annotation> PARSER = byteBuffer -> new Annotation(byteBuffer.getShort(), AnnotationNameAndValue.PARSER.parseMulti(byteBuffer));

    private final int typeIndex;

    private final List<AnnotationNameAndValue> nameAndValues;

    public Annotation(int typeIndex, List<AnnotationNameAndValue> nameAndValues) {
        this.typeIndex = typeIndex;
        this.nameAndValues = nameAndValues;
    }
}
