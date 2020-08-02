package Find.Findpkg;
import Find.Filepkg.File;

public interface Filter {
    boolean validate(File f);
}