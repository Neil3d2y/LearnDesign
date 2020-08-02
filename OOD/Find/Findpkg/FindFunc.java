package Find.Findpkg;

import Find.Filepkg.*;
import java.util.*;

class FilterByType implements Filter {
    FileType type;

    FilterByType(FileType t) {
        this.type = t;
    }

    public boolean validate(File f) {
        return f.getType() == this.type;
    }
}

class FilterByName implements Filter {
    String targetName;

    FilterByName(String targetName) {
        this.targetName = targetName;
    }

    public boolean validate(File f) {
        if (f.getName().length() < targetName.length()) return false;
        String prefix = f.getName().substring(0, this.targetName.length());
        return prefix.equals(this.targetName);
    }
}

class FilterBySize implements Filter {
    Integer lowerBound;
    Integer upperBound;

    public void setLowerBound(int lowerBound) { 
        this.lowerBound = lowerBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public boolean validate(File f) {
        if (lowerBound != null && f.getSize() < lowerBound) return false;
        if (upperBound != null && f.getSize() > upperBound) return false;
        return true;
    }
}

public class FindFunc {
    private List<Filter> conditions = new ArrayList<>();

    public void setUpRules() {
        FilterByName searchByName = new FilterByName("hello");
        FilterBySize searchBySize = new FilterBySize();
        searchBySize.setLowerBound(10);
        searchBySize.setUpperBound(100);
        FilterByType searchByType = new FilterByType(FileType.TXT);
        this.conditions.add(searchByName);
        this.conditions.add(searchBySize);
        this.conditions.add(searchByType);
    }

    public List<File> FindTargetFile(File file) {

        List<File> ret = new ArrayList<>();
        if (file == null) return ret;
        Queue<File> q = new LinkedList<>();

        q.add(file);

        while(!q.isEmpty()) {
            File curr = q.poll();
            // System.out.println("Debug: \n" + curr.toString());
            if (curr.isDir()) {
                if (curr.children == null) continue;
                for (File next : curr.children) {
                    q.add(next);
                }
            }
            else {
                boolean valid = true;
                for (Filter filter : this.conditions) {
                    if (filter.validate(curr) == false) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    ret.add(curr);
                }
            }
        }

        return ret;
    }
}