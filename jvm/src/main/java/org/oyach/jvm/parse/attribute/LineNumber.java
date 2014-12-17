package org.oyach.jvm.parse.attribute;

import org.oyach.jvm.parse.Parser;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class LineNumber {

    public static final Parser<LineNumber> PARSER = byteBuffer -> new LineNumber(byteBuffer.getShort(), byteBuffer.getShort());

    private final int startPc;

    private final int lineNumber;

    public LineNumber(int startPc, int lineNumber) {
        this.startPc = startPc;
        this.lineNumber = lineNumber;
    }
}
