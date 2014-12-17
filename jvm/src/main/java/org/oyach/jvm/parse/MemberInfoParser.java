package org.oyach.jvm.parse;

import org.oyach.jvm.parse.attribute.Attribute;

import java.nio.ByteBuffer;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class MemberInfoParser implements Parser<MemberInfo> {

    private final Parser<Attribute> attributeParser;

    public MemberInfoParser(Parser<Attribute> attributeParser) {
        this.attributeParser = attributeParser;
    }

    @Override
    public MemberInfo parse(ByteBuffer buffer) {
        return new MemberInfo(
                buffer.getShort(),
                buffer.getShort(),
                buffer.getShort(),
                new Attributes(attributeParser.parseMulti(buffer))
        );
    }
}