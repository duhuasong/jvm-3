package org.oyach.jvm.parse;

import org.oyach.jvm.core.util.ByteBufferUtils;
import org.oyach.jvm.parse.attribute.Attribute;
import org.oyach.jvm.parse.attribute.AttributeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class AttributeParser implements Parser<Attribute> {
    private static final Logger LOG = LoggerFactory.getLogger(AttributeParser.class);

    private final Object[] constantPool;

    public AttributeParser(Object[] constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public Attribute parse(ByteBuffer byteBuffer) {
        int index = byteBuffer.getShort();
        String name;
        try {
            name = (String) constantPool[index];
        } catch (Throwable t) {
            LOG.error("Looking for String at index {} but found {}", index, constantPool[index]);
            throw t;
        }
        AttributeType at = AttributeType.forString(name);
        if (at == null) {
            // not found - need to skip the buffer!
            ByteBufferUtils.getBytes(byteBuffer, byteBuffer.getInt());
            return null;
        }
        return at.parse(byteBuffer, this);
    }
}
