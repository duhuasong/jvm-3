package org.oyach.jvm.parse;

import java.util.Set;

/**
 * 类文件解析
 *
 * @author oyach
 * @since 0.0.1
 */
public class ClassFile {

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
}
