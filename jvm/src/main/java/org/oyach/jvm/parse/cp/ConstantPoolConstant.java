package org.oyach.jvm.parse.cp;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * 常量池
 *
 * 一共14种常量
 *
 * @author oyach
 * @since 0.0.1
 */
public enum ConstantPoolConstant {
    CLASS(7) {
        @Override
        public Object parse(ByteBuffer byteBuffer) {
            return new CpClass(byteBuffer.getShort());
        }
    },
    FIELD_REF(9) {
        @Override
        public Object parse(ByteBuffer byteBuffer) {
            return new CpFieldReference(byteBuffer.getShort(), byteBuffer.getShort());
        }
    },
    METHOD_REF(10) {
        @Override
        public Object parse(ByteBuffer byteBuffer) {
            return new CpMethodReference(byteBuffer.getShort(), byteBuffer.getShort());
        }
    },
    INTERFACE_METHOD_REF(11) {
        @Override
        public Object parse(ByteBuffer byteBuffer) {
            return new CpInterfaceMethodReference(byteBuffer.getShort(), byteBuffer.getShort());
        }
    },
    STRING(8) {
        @Override
        public Object parse(ByteBuffer byteBuffer) {
            return new CpString(byteBuffer.getShort());
        }
    },
    INTEGER(3) {
        @Override
        public Object parse(ByteBuffer byteBuffer) {
            return new CpInt(byteBuffer.getInt());
        }
    },
    FLOAT(4) {
        @Override
        public Object parse(ByteBuffer byteBuffer) {
            return new CpFloat(byteBuffer.getInt());
        }
    },
    LONG(5) {
        @Override
        public Object parse(ByteBuffer byteBuffer) {
            return new CpLong(byteBuffer.getInt(), byteBuffer.getInt());
        }
    },
    DOUBLE(6) {
        @Override
        public Object parse(ByteBuffer byteBuffer) {
            return new CpDouble(byteBuffer.getInt(), byteBuffer.getInt());
        }
    },
    NAME_AND_TYPE(12) {
        @Override
        public Object parse(ByteBuffer byteBuffer) {
            return new NameAndType(byteBuffer.getShort(), byteBuffer.getShort());
        }
    },
    UTF8(1) {
        @Override
        public Object parse(ByteBuffer byteBuffer) {
            int length = byteBuffer.getShort();
            byte[] bytes = new byte[length];
            byteBuffer.get(bytes);
            return new java.lang.String(bytes);
        }
    },
    INVOKE_DYNAMIC_INFO(18) {
        @Override
        public Object parse(ByteBuffer byteBuffer) {
            return new CpInvokeDynamicInfo(byteBuffer.getShort(), byteBuffer.getShort());
        }
    },
    METHOD_HANDLE(15) {
        @Override
        public Object parse(ByteBuffer byteBuffer) {

            return new CpMethodHandle(byteBuffer.get(), byteBuffer.getShort());
        }
    },
    METHOD_TYPE(16) {
        @Override
        public Object parse(ByteBuffer byteBuffer) {
            return new CpMethodType(byteBuffer.getShort());
        }
    };

    private final byte b;

    private ConstantPoolConstant(int b) {
        this.b = (byte) b;
    }

    private static final Map<Byte, ConstantPoolConstant> MAP = makeMap();

    private static Map<Byte, ConstantPoolConstant> makeMap() {
        Map<Byte, ConstantPoolConstant> map = new TreeMap<>();
        for (ConstantPoolConstant cpc : values()) {
            map.put(cpc.b, cpc);
        }
        return Collections.unmodifiableMap(map);
    }


    public static ConstantPoolConstant forByte(byte b) {
        ConstantPoolConstant cpc = MAP.get(b);
        if (cpc == null) {
            throw new IllegalArgumentException("No ConstantPoolConstant for " + b);
        }
        return cpc;
    }

    public abstract Object parse(ByteBuffer byteBuffer);
}
