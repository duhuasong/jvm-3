package org.oyach.jvm.load;

/**
 * Extension ClassLoader（扩展类加载器）
 *
 * @author oyach
 * @since 0.0.1
 */
public class ExtClassLoader extends ClassLoader {
    public ExtClassLoader(ClassLoader parent) {
        super(parent);
    }
}
