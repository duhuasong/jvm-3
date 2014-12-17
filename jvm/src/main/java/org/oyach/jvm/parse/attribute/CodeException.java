package org.oyach.jvm.parse.attribute;

import org.oyach.jvm.parse.Parser;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class CodeException {
    public static final Parser<CodeException> PARSER = byteBuffer -> new CodeException(byteBuffer.getShort(),
            byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getShort());

    private final int startPc;

    private final int endPc;

    private final int handlerPc;

    private final int catchType;

    private CodeException(int startPc, int endPc, int handlerPc, int catchType) {
        this.startPc = startPc;
        this.endPc = endPc;
        this.handlerPc = handlerPc;
        this.catchType = catchType;
    }

    public int getStartPc() {
        return startPc;
    }

    public int getEndPc() {
        return endPc;
    }

    public int getHandlerPc() {
        return handlerPc;
    }

    public int getCatchType() {
        return catchType;
    }
}
