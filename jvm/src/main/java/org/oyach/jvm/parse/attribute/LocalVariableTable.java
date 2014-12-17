package org.oyach.jvm.parse.attribute;

import java.util.List;

import static java.util.Collections.unmodifiableList;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class LocalVariableTable extends Attribute {

    private final List<LocalVariable> localVariables;

    protected LocalVariableTable(List<LocalVariable> localVariables) {
        super(AttributeType.LOCAL_VARIABLE_TABLE);
        this.localVariables = unmodifiableList(localVariables);
    }

    public List<LocalVariable> getLocalVariables() {
        return localVariables;
    }
}