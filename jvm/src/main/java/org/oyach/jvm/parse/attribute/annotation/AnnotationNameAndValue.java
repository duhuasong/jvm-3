package org.oyach.jvm.parse.attribute.annotation;

import org.oyach.jvm.parse.Parser;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class AnnotationNameAndValue {
    public static final Parser<AnnotationNameAndValue> PARSER = byteBuffer -> new AnnotationNameAndValue(byteBuffer.getShort(),
            ElementValue.PARSER.parse(byteBuffer));

    private final int nameIndex;

    private final ElementValue value;

    public AnnotationNameAndValue(int nameIndex, ElementValue value) {
        this.nameIndex = nameIndex;
        this.value = value;
    }
}
