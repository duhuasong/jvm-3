package org.oyach.jvm.parse;

import com.google.common.io.ByteStreams;
import jdk.internal.org.objectweb.asm.tree.ClassNode;
import org.apache.bcel.Repository;
import org.apache.bcel.classfile.JavaClass;
import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.InputStream;

/**
 * 测试使用ASM进行解析类
 *
 * @author oyach
 * @since 0.0.1
 */
public class ClassReaderTest {


    @Test
    public void test01() throws Exception {

        InputStream inputStream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream("org/oyach/jvm/parse/ClassFileParseTest.class");
        byte[] bytes = ByteStreams.toByteArray(inputStream);


        ClassReader classReader = new ClassReader(bytes);

        ClassNode classNode = new ClassNode();

        ClassVisitor classVisitor = new ClassWriter(classReader, 0);

    }

    @Test
    public void test02() throws Exception {

    }
}
