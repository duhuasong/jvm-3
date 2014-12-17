package org.oyach.jvm.launcher;


import org.oyach.jvm.load.BootstrapClassLoader;
import sun.tools.java.ClassPath;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 程序入口
 *
 * @author oyach
 * @since 0.0.1
 */
public class Launcher {

    //private static final MethodSignature MAIN_METHOD_SIGNATURE = MethodSignature.parse("main", "([Ljava/lang/String;)V");

    private final ClassPath classPath;

    private final String mainClassName;

    private final String[] args;

    private final Thread mainThread;

    public Launcher(ClassPath classPath, String mainClassName, String... args) throws Exception {
        this.classPath = classPath;
        this.mainClassName = mainClassName;
        this.args = args;

        // 初始化


        // 启动类加载器
        BootstrapClassLoader bootstrapClassLoader = new BootstrapClassLoader(classPath, mainClassName);

        // 主线程
        mainThread = createMainThread();

        Class<?> mainClass = Class.forName(mainClassName);

        // 获取入口
        Method main = getMainMethod(mainClass);

        // 执行main方法
    }

    /**
     * 创建一个主线程
     *
     * @return 完整的线程
     */
    private static Thread createMainThread() {

        return null;
    }

    /**
     * 获取main方法
     *
     * @param mainClass main方法所在类
     * @return main方法
     * @throws NoSuchMethodException 当指定入口类没有main方法的时候抛出
     */
    private static Method getMainMethod(Class<?> mainClass) throws NoSuchMethodException{
        Method method = mainClass.getMethod("main", String[].class);

        // 判断是否是静态方法
        if (!Modifier.isStatic(method.getModifiers())){
            throw new NoSuchMethodException();
        }
        return method;
    }

}
