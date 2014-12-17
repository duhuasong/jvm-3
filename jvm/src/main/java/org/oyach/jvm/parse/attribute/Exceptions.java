package org.oyach.jvm.parse.attribute;

import java.util.List;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class Exceptions extends Attribute {

    private final List<Exception> exceptions;

    protected Exceptions(List<Exception> exceptions) {
        super(AttributeType.EXCEPTIONS);
        this.exceptions = exceptions;
    }
}