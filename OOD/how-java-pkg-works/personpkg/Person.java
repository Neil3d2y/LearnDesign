package personpkg;

public class Person {
   private String Firstname;
   private String LastName;

   public Person(String f, String l) {
       this.Firstname = f;
       this.LastName = l;
   }

   @Override
   public String toString() {
       return "My name is " + Firstname + " " + LastName + 
              "! Nice to meet you!";
   }
}