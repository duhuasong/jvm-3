package org.oyach.jvm;

import org.junit.Test;
import org.oyach.jvm.launcher.Launcher;
import sun.tools.java.ClassPath;

import static org.junit.Assert.*;

public class JVMTest {

    private final static String classOutPath = "build/classes/test";

    @Test
    public void testRun() throws Exception {
        String projectPath = System.getProperty("user.dir");

        // 运行时候的路径
        ClassPath classPath = new ClassPath(projectPath + "/" + classOutPath);

        // 设置方法入口
        String mainClass = "org.oyach.jvm.demo.Main";

        // 启动程序
       // Launcher launcher = new Launcher();
    }
}