package org.oyach.jvm.core.lang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class Throwable {

    // 记录异常信息，全局
    private static final List<Throwable> SUPPRESSED_SENTINEL =
            Collections.unmodifiableList(new ArrayList<Throwable>(0));


    private static final StackTraceElement[] UNASSIGNED_STACK = new StackTraceElement[0];


}
