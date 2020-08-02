package Find.Filepkg;

import java.util.*;

public class File {
    FileType type;
    public boolean isDir;
    int size;
    String name;
    Date createTs;
    public List<File> children;

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    public void setType(FileType t) {
        this.type = t;
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    public Date getCreateTs() {
        return this.createTs;
    }

    public FileType getType() {
        return this.type;
    }

    public boolean isDir() {
        return this.isDir;
    }

    @Override
    public String toString() {
        return "{\n" + 
            "name: " + this.name + "\n" +
            "type: " + this.type + "\n" +
            "size: " + this.size + " bytes\n" + 
            "}";
    }
}