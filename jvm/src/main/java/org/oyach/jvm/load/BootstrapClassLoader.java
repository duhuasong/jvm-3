package org.oyach.jvm.load;

import com.google.common.io.ByteStreams;
import com.sun.tools.classfile.Dependencies;
import org.oyach.jvm.core.lang.type.ClassObject;

import org.oyach.jvm.launcher.MethodArea;
import org.oyach.jvm.parse.ClassFileReader;
import org.oyach.jvm.parse.ClassFileResource;
import org.oyach.jvm.parse.MemberInfo;
import org.oyach.jvm.parse.cp.CpClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.tools.java.ClassFile;
import sun.tools.java.ClassPath;

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

    //记录加载解析的类
    private final Map<String, ClassFileReader> classFileReaders = new HashMap<>();

    // 单例，只实例化一个启动类加载器
//    private final static BootstrapClassLoader boot;

//    // 在加载该类时候就进行实例化,因为屏蔽掉了外部实例化调用，所以保证了一次使用
//    static {
//        String libJarPath = System.getProperty("java.lib.jar.path");
//        ClassPath classPath = new ClassPath(libJarPath);
//        boot = new BootstrapClassLoader(classPath);
//    }


//    public static BootstrapClassLoader getInstance() {
//        return boot;
//    }


    /**
     * 主要是Main载入
     *
     * 这时候JVM并没有开始工作，所以如何解析到main方法呢？
     *
     * @param classPath 基本类型加载路径
     * @param mainClassName main方法所在类
     */
    public BootstrapClassLoader(ClassPath classPath, String mainClassName){
        try {
            load(classPath, mainClassName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载类
     *
     * @param classPath 基本类型加载路径
     * @throws IOException
     */
    private void load(ClassPath classPath, String mainClassName) throws IOException {

        if (!mainClassName.endsWith(".class")){
            mainClassName = mainClassName.replace(".", "/");
            mainClassName += ".class";
        }
        ClassFile classFile = classPath.getFile(mainClassName);

        // 方法区放入结构
        MethodArea.createClassFile(classFile);

        // 解析模板
        ClassFileReader reader = ClassFileReader.reader(classFile.getInputStream());


        classFileReaders.put(getClassName(reader.getThisClass(), reader.getConstantPool()), reader);
    }

    private static String getClassName(int index, Object[] constantPool) {
        CpClass cpClass = (CpClass) constantPool[index];
        return (String) constantPool[cpClass.getNameIndex()];
    }

}
