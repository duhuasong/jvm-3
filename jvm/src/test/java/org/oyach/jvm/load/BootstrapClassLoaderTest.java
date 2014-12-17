package org.oyach.jvm.load;

import org.junit.Test;
import sun.tools.java.ClassPath;

public class BootstrapClassLoaderTest {
    private final static String classOutPath = "build/classes/test";

    @Test
    public void test01() throws Exception {

        String projectPath = System.getProperty("user.dir");

        // 运行时候的路径
        ClassPath classPath = new ClassPath(projectPath + "/" + classOutPath);

        // 设置方法入口
        String mainClass = "org.oyach.jvm.demo.HelloWorld";

        BootstrapClassLoader bootstrapClassLoader = new BootstrapClassLoader(classPath, mainClass);

    }
}