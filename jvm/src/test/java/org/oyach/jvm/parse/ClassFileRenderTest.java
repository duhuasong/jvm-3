package org.oyach.jvm.parse;

import com.google.common.io.ByteStreams;
import org.junit.Test;

import java.io.InputStream;

public class ClassFileRenderTest {

    @Test
    public void testGetInstance() throws Exception {
        InputStream inputStream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream("org/oyach/jvm/demo/HelloWorld.class");

        ClassFileReader parse = ClassFileReader.reader(inputStream);

    }

    @Test
    public void testRead() throws Exception {

    }
}