package org.oyach.jvm.parse;

import com.google.common.io.ByteStreams;
import org.oyach.jvm.parse.attribute.Attribute;
import org.oyach.jvm.parse.cp.ConstantPoolConstant;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Set;

/**
 * 类文件解析
 *
 * 读入类文件二进制后进行解析
 *
 * @author oyach
 * @since 0.0.1
 */
public class ClassFileReader {
    // class 文件的魔数
    private static final int MAGIC_NUMBER = 0xCAFEBABE;


    //Class文件的次版本号
    private int minorVersion;
    //Class文件的主版本号
    private int majorVersion;
    // 常量池
    private Object[] constantPool;
    //
    private Set<Modifier> modifiers;

    private int thisClass;

    private int superClass;

    private int[] interfaces;

    private List<MemberInfo> fields;

    private List<MemberInfo> methods;

    private Attributes attributes;

    private ClassFileReader() {
    }

    public static ClassFileReader reader(InputStream is) throws IOException {
        byte[] bytes = ByteStreams.toByteArray(is);
        // 采用NIO来读取
        final ByteBuffer buffer = ByteBuffer.wrap(bytes);

        // 验证魔数是否正确
        verifyMagicNumber(buffer.getInt());

        ClassFileReader classFile = new ClassFileReader();

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


        Parser<Attribute> attributeParser = new AttributeParser(cp);
        Parser<MemberInfo> fieldOrMethodInfoParser =
                new MemberInfoParser(attributeParser);

        //类中字段的数量
        classFile.setFields(fieldOrMethodInfoParser.parseMulti(buffer));

        //方法的数量
        classFile.setMethods(fieldOrMethodInfoParser.parseMulti(buffer));

        //类或接口所定义的属性的基本信息
        classFile.setAttributes(new Attributes(attributeParser.parseMulti(buffer)));

        return classFile;
    }

    private static void verifyMagicNumber(int num) {
        if (num != MAGIC_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    public Object[] getConstantPool() {
        return constantPool;
    }

    public void setConstantPool(Object[] constantPool) {
        this.constantPool = constantPool;
    }

    public boolean hasModifier(Modifier modifier) {
        return modifiers.contains(modifier);
    }

    public void setAccessFlags(int accessFlags) {
        this.modifiers = Modifier.translate(accessFlags);
    }

    public int getThisClass() {
        return thisClass;
    }

    public void setThisClass(int thisClass) {
        this.thisClass = thisClass;
    }

    public int getSuperClass() {
        return superClass;
    }

    public void setSuperClass(int superClass) {
        this.superClass = superClass;
    }

    public int[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(int[] interfaces) {
        this.interfaces = interfaces;
    }

    public List<MemberInfo> getFields() {
        return fields;
    }

    public void setFields(List<MemberInfo> fields) {
        this.fields = fields;
    }

    public List<MemberInfo> getMethods() {
        return methods;
    }

    public void setMethods(List<MemberInfo> methods) {
        this.methods = methods;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Set<Modifier> getModifiers() {
        return modifiers;
    }

}
