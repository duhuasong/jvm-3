package org.oyach.jvm.core.util;

import java.nio.ByteBuffer;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class ByteBufferUtils {

    public static byte[] getBytes(ByteBuffer byteBuffer, int length){
        byte[] bytes = new byte[length];
        byteBuffer.get(bytes);
        return bytes;
    }
}
