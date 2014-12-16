package org.oyach.jvm.parse;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * description
 *
 * @author oyach
 * @since 0.0.1
 */
public class PathClassFileResource implements ClassFileResource {

    private final Path path;

    public PathClassFileResource(Path path) {
        this.path = path;
    }

    @Override
    public String getName() {
        return path.toString();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return Files.newInputStream(path);
    }
}
