package org.oyach.jvm.core.lang.clazz;

/**
 * 解析后类的类型对象
 *
 * @author oyach
 * @since 0.0.1
 */
public final class Class {

    // 加载器
    private final ClassLoader classLoader;


    public Class(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
}
