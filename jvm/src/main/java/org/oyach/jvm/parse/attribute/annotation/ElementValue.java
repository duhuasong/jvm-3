package org.oyach.jvm.parse.attribute.annotation;

import org.oyach.jvm.parse.Parser;

import java.nio.ByteBuffer;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public abstract class ElementValue {

    public static final Parser<ElementValue> PARSER = new Parser<ElementValue>() {
        @Override
        public ElementValue parse(ByteBuffer byteBuffer) {
            char c = (char) byteBuffer.get();
            switch (c) {
                case 'B':
                case 'C':
                case 'D':
                case 'F':
                case 'I':
                case 'J':
                case 'S':
                case 'Z':
                case 's':
                    return new ConstantElementValue(c, byteBuffer.getShort());
                case 'c':
                    return new ClassElementValue(c, byteBuffer.getShort());
                case 'e':
                    return new EnumElementValue(c, byteBuffer.getShort(), byteBuffer.getShort());
                case '@':
                    return new AnnotationElementValue(c, Annotation.PARSER.parse(byteBuffer));
                case '[':
                    return new ArrayElementValue(c, parseMulti(byteBuffer));
                default:
                    throw new IllegalArgumentException("Unknown annotation element value type: " + c);
            }
        }
    };


    private final char tag;

    protected ElementValue(char tag) {
        this.tag = tag;
    }
}

