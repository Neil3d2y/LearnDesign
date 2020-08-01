package Find;

public class FindTest {

   FileType type;

   public FindTest(FileType t) {
       this.type = t;
   }
   public static void main(String[] args) {
        FindTest test = new FindTest(FileType.CSV);

        System.out.println("The test file type is " + test.type);
   }
}