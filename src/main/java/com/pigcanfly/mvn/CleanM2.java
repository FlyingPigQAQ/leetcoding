package com.pigcanfly.mvn;

import java.io.File;

/**
 * @author tobbyquinn
 * @date 2020/04/16
 */
public class CleanM2 {


    public static void main(String[] args) {
        String M2_HOME = "/Users/tobbyquinn/.m2";
        new CleanM2().run(M2_HOME);
    }

    private void run(String m2_home) {
        File file = new File(m2_home + "/repository/");
        cleanM2RepositoryByPath(file);
    }

    private void cleanM2RepositoryByPath(File root) {
        if (!isHasDirectoryInPath(root)) {
            if (isDirtyMavenRepositoryDirectory(root)) {
                recurisiveDelete(root);
            }
            return;
        }

        File[] files = root.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                cleanM2RepositoryByPath(file);
            }
        }

    }

    public void recurisiveDelete(File root) {
        if (root.isFile()) {
            root.delete();
            return;
        }
        File[] files = root.listFiles();
        for (File file : files) {
            recurisiveDelete(file);
        }
        //删除目录
        root.delete();
    }

    public boolean isHasDirectoryInPath(File path) {
        if (path.isFile()) {
            return false;
        }
        boolean hasDirectory = false;
        if (path.listFiles() == null) {
            System.out.println(path.getAbsolutePath());
        }
        for (File file : path.listFiles()) {
            if (file.isDirectory()) {
                hasDirectory = true;
                break;
            }
        }
        return hasDirectory;
    }

    public boolean isDirtyMavenRepositoryDirectory(File path) {
        if (path.isFile()) {
            throw new RuntimeException("路径不为目录路径");
        }
        String[] list = path.list((dir, fileName) -> {
            return !fileName.endsWith(".lastUpdated");
        });
        return list.length == 0;
    }
}
