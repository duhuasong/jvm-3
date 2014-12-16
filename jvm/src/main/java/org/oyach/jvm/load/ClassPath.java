package org.oyach.jvm.load;


import org.oyach.jvm.parse.ClassFileResource;
import org.oyach.jvm.parse.PathClassFileResource;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 这个类是用于处理一个类的路径，通常可能是目录或者zip文件等
 *
 * @author oyach
 * @since 0.0.1
 */
public class ClassPath {
    static final char dirSeparator;

    static {
        dirSeparator = System.getProperty("user.dir").charAt(0);
    }

    private final Path path;

    private final boolean recursive;

    public ClassPath(String path) {
        this(Paths.get(path), true);
    }

    public ClassPath(String path, boolean recursive) {
        this(Paths.get(path), recursive);
    }

    public ClassPath(Path path, boolean recursive) {
        this.path = path;
        this.recursive = recursive;
    }

    public List<ClassFileResource> getAllClassFileResource(){
        int depth = recursive ? Integer.MAX_VALUE : 1;

        final List<ClassFileResource> classFileResources = new ArrayList<>();

        try {
            Files.walkFileTree(path, Collections.emptySet(), depth, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    classFileResources.add(new PathClassFileResource(file));
                    return FileVisitResult.CONTINUE;
                }

            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return classFileResources;
    }
}
