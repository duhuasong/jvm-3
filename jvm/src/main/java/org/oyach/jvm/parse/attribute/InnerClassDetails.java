package org.oyach.jvm.parse.attribute;

import org.oyach.jvm.parse.Parser;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class InnerClassDetails {
    public static final Parser<InnerClassDetails> PARSER = byteBuffer -> new InnerClassDetails(byteBuffer.getShort(),
            byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getShort());

    private final int innerClassInfoIndex;

    private final int outerClassInfoIndex;

    private final int innerNameIndex;

    private final int innerClassAccessFlags;

    private InnerClassDetails(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex, int innerClassAccessFlags) {
        this.innerClassInfoIndex = innerClassInfoIndex;
        this.outerClassInfoIndex = outerClassInfoIndex;
        this.innerNameIndex = innerNameIndex;
        this.innerClassAccessFlags = innerClassAccessFlags;
    }
}
