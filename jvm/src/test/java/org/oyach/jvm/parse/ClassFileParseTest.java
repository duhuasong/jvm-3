package org.oyach.jvm.parse;

import com.google.common.io.ByteStreams;
import org.junit.Test;

import java.io.InputStream;

public class ClassFileParseTest {

    @Test
    public void testGetInstance() throws Exception {
        ClassFileParse parse = ClassFileParse.getInstance();
        InputStream inputStream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream("org/oyach/jvm/parse/ClassFileParseTest.class");
        parse.read(ByteStreams.toByteArray(inputStream));
    }

    @Test
    public void testRead() throws Exception {

    }
}