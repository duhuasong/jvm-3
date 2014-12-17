package org.oyach.jvm.launcher;

import org.oyach.jvm.parse.ClassFileResource;
import sun.tools.java.ClassFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法区实现
 *
 * @author oyach
 * @since 0.0.1
 */
public class MethodArea {

    // 字节码静态内存结构
    private static final Map<String, ClassFile> classFiles = new HashMap<>();

    private MethodArea(){}

    /**
     * 在方法区创建字节码的静态内存结构
     *
     * @param classFile 需要创建的二进制码结构
     */
    public static void createClassFile(ClassFile classFile){
        classFiles.put(classFile.getName(), classFile);
    }
}
