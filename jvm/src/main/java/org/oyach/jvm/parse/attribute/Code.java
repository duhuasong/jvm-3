package org.oyach.jvm.parse.attribute;

import org.oyach.jvm.parse.Attributes;

import java.util.List;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class Code extends Attribute {

    private final int maxStack;

    private final int maxLocals;

    private final byte[] code;

    private final List<CodeException> codeExceptions;

    private final Attributes attributes;

    Code(int maxStack, int maxLocals, byte[] code, List<CodeException> codeExceptions, Attributes attributes) {
        super(AttributeType.CODE);
        this.maxStack = maxStack;
        this.maxLocals = maxLocals;
        this.code = code;
        this.codeExceptions = codeExceptions;
        this.attributes = attributes;
    }

    public byte[] getCode() {
        return code;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public List<CodeException> getCodeExceptions() {
        return codeExceptions;
    }
}

