package Find;
import java.util.*;

import Find.Filepkg.*;
import Find.Findpkg.*;

public class FindTest {
    public static void main(String[] args) {
        // Initialization
        File root = new File();
        root.isDir = true;
        root.children = new ArrayList();

        File file1 = new File();
        file1.setName("hellof1");
        file1.setType(FileType.CSV);
        file1.isDir = false;
        file1.setSize(50);

        File file2 = new File();
        file2.setName("hellof2");
        file2.setType(FileType.TXT);
        file2.isDir = false;
        file2.setSize(30);

        File file3 = new File();
        file3.setName("Byef3");
        file3.setType(FileType.TXT);
        file3.isDir = false;
        file3.setSize(120);

        File file4 = new File();
        file4.setName("hellof4");
        file4.setType(FileType.TXT);
        file4.isDir = false;
        file4.setSize(66);

        File dir1 = new File();
        dir1.isDir = true;
        dir1.children = new ArrayList<>();

        File dir2 = new File();
        dir2.isDir = true;
        dir2.children = new ArrayList<>();

        File dir1File1 = new File();
        dir1File1.setName("hellodir1XXX");
        dir1File1.setType(FileType.CSV);
        dir1File1.isDir = false;
        dir1File1.setSize(123);

        File dir1File2 = new File();
        dir1File2.setName("hellodir1hihihi");
        dir1File2.setType(FileType.TXT);
        dir1File2.isDir = false;
        dir1File2.setSize(555);

        dir1.children.add(dir1File1);
        dir1.children.add(dir1File2);

        File dir2File1 = new File();
        dir2File1.setName("Secret");
        dir2File1.setType(FileType.MP3);
        dir2File1.isDir = false;
        dir2File1.setSize(9999);

        dir2.children.add(dir2File1);

        root.children.add(dir1);
        root.children.add(dir2);
        root.children.add(file1);
        root.children.add(file2);
        root.children.add(file3);
        root.children.add(file4);
        /*
        Following is the testing part
        */

        FindFunc finder = new FindFunc();
        finder.setUpRules();
        List<File> ret = finder.FindTargetFile(root);

        System.out.println("Start checking....");
        for (File f : ret) {
            System.out.println(f.toString());
        }
        System.out.println("Compelete....");
    }
}