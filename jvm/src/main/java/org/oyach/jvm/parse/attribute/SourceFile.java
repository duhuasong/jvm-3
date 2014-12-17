package org.oyach.jvm.parse.attribute;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class SourceFile extends Attribute {

    private final int sourcefileIndex;

    SourceFile(int sourcefileIndex) {
        super(AttributeType.SOURCE_FILE);
        this.sourcefileIndex = sourcefileIndex;
    }
}
