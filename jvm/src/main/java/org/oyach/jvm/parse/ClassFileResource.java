package org.oyach.jvm.parse;

import java.io.IOException;
import java.io.InputStream;

/**
 * java 文件的静态内存结构
 *
 * @author oyach
 * @since 0.0.1
 */
public interface ClassFileResource {


    String getName();

    InputStream getInputStream() throws IOException;
}
