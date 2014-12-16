package org.oyach.jvm.load;

import org.oyach.jvm.core.lang.type.ClassObject;
import org.oyach.jvm.parse.ClassFile;
import org.oyach.jvm.parse.ClassFileParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * BootStrap ClassLoader（启动类加载器）
 *
 * 启动类加载器作为顶层类加载器，所以没有父类。并且扩展类加载器直接访问父类加载器也不能获得这个加载器。
 * 这个加载器只能在JVM中使用。
 *
 * @author oyach
 * @since 0.0.1
 */
public class BootstrapClassLoader {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassLoader.class);

    // 加载默认JVM类型
    private final static Map<String, ClassObject> classes = new HashMap<>();

    private final Map<String, ClassFile> classFiles = new HashMap<>();

    // 单例，只实例化一个启动类加载器
    private final static BootstrapClassLoader boot;

    // 在加载该类时候就进行实例化,因为屏蔽掉了外部实例化调用，所以保证了一次使用
    static {
        String libJarPath = System.getProperty("java.lib.jar.path");
        ClassPath classPath = new ClassPath(libJarPath);
        boot = new BootstrapClassLoader(classPath);
    }

    /**
     * 禁调默认构造函数
     * @param classPath 基本类型加载路径
     */
    private BootstrapClassLoader(ClassPath classPath){
        try {
            load(classPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载类
     * @param classPath 基本类型加载路径
     * @throws IOException
     */
    private void load(ClassPath classPath) throws IOException {
        // 解析模板
        ClassFileParse parse = ClassFileParse.getInstance();



    }

}
