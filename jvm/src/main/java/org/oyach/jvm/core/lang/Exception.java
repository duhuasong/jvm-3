package org.oyach.jvm.core.lang;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class Exception extends Throwable {

    private final int exceptionClassIndex;

    public Exception(int exceptionClassIndex) {
        this.exceptionClassIndex = exceptionClassIndex;
    }
}
