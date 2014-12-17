package org.oyach.jvm.parse.attribute;

import org.oyach.jvm.parse.Parser;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class LocalVariable {
    public static final Parser<LocalVariable> PARSER = byteBuffer -> new LocalVariable(byteBuffer.getShort(),
            byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getShort());

    private final int startPc;

    private final int length;

    private final int nameIndex;

    private final int descriptorIndex;

    private final int index;

    public LocalVariable(int startPc, int length, int nameIndex, int descriptorIndex, int index) {
        this.startPc = startPc;
        this.length = length;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.index = index;
    }
}
