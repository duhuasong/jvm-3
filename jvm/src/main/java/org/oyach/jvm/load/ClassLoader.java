package org.oyach.jvm.load;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.tools.java.ClassFile;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassLoader 是双亲委派模式，JVM中默认提供了3个实现
 *
 * 1.BootStrap ClassLoader（启动类加载器）：是Java类加载层次中最顶层的类加载器，负责加载JDK中的核心类库，
 * 如：rt.jar、resources.jar、charsets.jar等，可通过如下程序获得该类加载器从哪些地方加载了相关的jar或class文件。
 * 2.Extension ClassLoader（扩展类加载器）：负责加载Java的扩展类库，默认加载JAVA_HOME/jre/lib/ext/目下的所有jar。
 * 3.App ClassLoader：称为系统类加载器，负责加载应用程序classpath目录下的所有jar和class文件。
 *
 * @author oyach
 * @since 0.0.1
 */
public abstract class ClassLoader {
    private static final Logger LOG = LoggerFactory.getLogger(ClassLoader.class);

    /**
     * 双亲委派模型中的父类，在BootStrap ClassLoader中为
     */
    private final ClassLoader parent;

    //记录加载解析的类
    private final Map<String, ClassFile> classFiles = new HashMap<>();

    public ClassLoader(ClassLoader parent) {
        this.parent = parent;
    }


}
