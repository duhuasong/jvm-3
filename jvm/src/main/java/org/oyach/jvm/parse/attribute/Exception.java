package org.oyach.jvm.parse.attribute;

import org.oyach.jvm.parse.Parser;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class Exception {

    public static final Parser<Exception> PARSER = byteBuffer -> new Exception(byteBuffer.getShort());

    private final int exceptionClassIndex;

    public Exception(int exceptionClassIndex) {
        this.exceptionClassIndex = exceptionClassIndex;
    }
}
