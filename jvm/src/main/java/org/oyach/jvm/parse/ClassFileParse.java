package org.oyach.jvm.parse;

import org.oyach.jvm.parse.cp.ConstantPoolConstant;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * 类文件解析
 * <p>
 * 读入类文件二进制后进行解析
 *
 * @author oyach
 * @since 0.0.1
 */
public class ClassFileParse {
    // class 文件的魔数
    private static final int MAGIC_NUMBER = 0xCAFEBABE;

    private static ClassFileParse ourInstance = new ClassFileParse();

    public static ClassFileParse getInstance() {
        return ourInstance;
    }

    private ClassFileParse() {
    }

    public ClassFile read(byte[] bytes) throws IOException {
        // 采用NIO来读取
        final ByteBuffer buffer = ByteBuffer.wrap(bytes);

        // 验证魔数是否正确
        verifyMagicNumber(buffer.getInt());

        ClassFile classFile = new ClassFile();

        // 解析版本号
        classFile.setMinorVersion(buffer.getShort());
        classFile.setMajorVersion(buffer.getShort());

        // 解析常量池信息
        int cpCount = buffer.getShort();
        Object[] cp = new Object[cpCount];
        for (int i = 1; i < cpCount; i++) {
            ConstantPoolConstant cpc = ConstantPoolConstant.forByte(buffer.get());

            cp[i] = cpc.parse(buffer);

            if (cpc == ConstantPoolConstant.DOUBLE || cpc == ConstantPoolConstant.LONG) {
                i++;
            }
        }
        classFile.setConstantPool(cp);

        //类或者接口以及访问信息
        classFile.setAccessFlags(buffer.getShort());

        //类的索引值
        classFile.setThisClass(buffer.getShort());

        //父类索引值
        classFile.setSuperClass(buffer.getShort());

        //接口数量及信息
        int[] interfaces = new int[buffer.getShort()];
        for (int i = 0; i < interfaces.length; i++) {
            interfaces[i] = buffer.getShort();
        }
        classFile.setInterfaces(interfaces);

        //类中字段的数量

        //方法的数量

        //Code数量

        return null;
    }

    private static void verifyMagicNumber(int num) {
        if (num != MAGIC_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

}
