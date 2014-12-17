package org.oyach.jvm.parse;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public interface Parser<T> {

    default List<T> parseMulti(ByteBuffer byteBuffer) {
        int size = byteBuffer.getShort();
        List<T> list = size == 0 ? Collections.emptyList() : new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(parse(byteBuffer));
        }
        return list;
    }

    T parse(ByteBuffer byteBuffer);

}
