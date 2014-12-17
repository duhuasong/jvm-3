package org.oyach.jvm.parse.attribute;

import org.oyach.jvm.core.util.ByteBufferUtils;
import org.oyach.jvm.parse.Attributes;
import org.oyach.jvm.parse.Parser;
import org.oyach.jvm.parse.attribute.annotation.Annotation;
import org.oyach.jvm.parse.attribute.annotation.RuntimeInvisibleAnnotations;
import org.oyach.jvm.parse.attribute.annotation.RuntimeVisibleAnnotations;

import java.nio.ByteBuffer;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public enum AttributeType {
    CONSTANT_VALUE("ConstantValue") {
        @Override
        Attribute doParse(ByteBuffer byteBuffer, Parser<Attribute> attributeParser) {
            return new ConstantValue(byteBuffer.getShort());
        }
    },
    CODE("Code") {
        @Override
        Attribute doParse(ByteBuffer byteBuffer, Parser<Attribute> attributeParser) {
            return new Code(
                    byteBuffer.getShort(),
                    byteBuffer.getShort(),
                    ByteBufferUtils.getBytes(byteBuffer, byteBuffer.getInt()),
                    CodeException.PARSER.parseMulti(byteBuffer),
                    new Attributes(attributeParser.parseMulti(byteBuffer))
            );
        }
    },
    EXCEPTIONS("Exceptions") {
        @Override
        Attribute doParse(ByteBuffer byteBuffer, Parser<Attribute> attributeParser) {
            return new Exceptions(
                    Exception.PARSER.parseMulti(byteBuffer)
            );
        }
    },
    ENCLOSING_METHOD("EnclosingMethod") {
        @Override
        Attribute doParse(ByteBuffer byteBuffer, Parser<Attribute> attributeParser) {
            return new EnclosingMethod(byteBuffer.getShort(), byteBuffer.getShort());
        }
    },
    INNER_CLASSES("InnerClasses") {
        @Override
        Attribute doParse(ByteBuffer byteBuffer, Parser<Attribute> attributeParser) {
            return new InnerClass(
                    InnerClassDetails.PARSER.parseMulti(byteBuffer)
            );
        }
    },
    SYNTHETIC("Synthetic") {
        @Override
        Attribute doParse(ByteBuffer byteBuffer, Parser<Attribute> attributeParser) {
            return new Synthetic();
        }
    },
    SOURCE_FILE("SourceFile") {
        @Override
        Attribute doParse(ByteBuffer byteBuffer, Parser<Attribute> attributeParser) {
            return new SourceFile(byteBuffer.getShort());
        }
    },
    LINE_NUMBER_TABLE("LineNumberTable") {
        @Override
        Attribute doParse(ByteBuffer byteBuffer, Parser<Attribute> attributeParser) {
            return new LineNumberTable(
                    LineNumber.PARSER.parseMulti(byteBuffer)
            );
        }
    },
    LOCAL_VARIABLE_TABLE("LocalVariableTable") {
        @Override
        Attribute doParse(ByteBuffer byteBuffer, Parser<Attribute> attributeParser) {
            return new LocalVariableTable(
                    LocalVariable.PARSER.parseMulti(byteBuffer)
            );
        }
    },
    DEPRECATED("Deprecated") {
        @Override
        Attribute doParse(ByteBuffer byteBuffer, Parser<Attribute> attributeParser) {
            return new Deprecated();
        }
    },
    RUNTIME_VISIBLE_ANNOTATIONS("RuntimeVisibleAnnotations") {
        @Override
        Attribute doParse(ByteBuffer byteBuffer, Parser<Attribute> attributeParser) {
            return new RuntimeVisibleAnnotations(Annotation.PARSER.parseMulti(byteBuffer));
        }
    },
    RUNTIME_INVISIBLE_ANNOTATIONS("RuntimeInvisibleAnnotations") {
        @Override
        Attribute doParse(ByteBuffer byteBuffer, Parser<Attribute> attributeParser) {
            return new RuntimeInvisibleAnnotations(Annotation.PARSER.parseMulti(byteBuffer));
        }
    },
    SIGNATURE("Signature") {
        @Override
        Attribute doParse(ByteBuffer byteBuffer, Parser<Attribute> attributeParser) {
            return new Signature(byteBuffer.getShort());
        }
    };

    private final String string;

    private AttributeType(String string) {
        this.string = string;
    }

    abstract Attribute doParse(ByteBuffer byteBuffer, Parser<Attribute> attributeParser);

    public Attribute parse(ByteBuffer byteBuffer, Parser<Attribute> attributeParser) {
        byteBuffer.getInt(); // The size, which we don't care about;
        return doParse(byteBuffer, attributeParser);
    }

    public static AttributeType forString(String str) {
        for (AttributeType at : values()) {
            if (at.string.equals(str)) {
                return at;
            }
        }
//        System.err.println("No AttributeType named " + str);
        return null;
    }
}
