1. `personpkg` is the upper level package and `Person.java` defines *Person* class. To include *Person* class in my main function
```diff
+import personpkg.Person;
``` 

2. Inside personpkg there is another pkg called `shapepkg` which includes:
- Shape.java as *Shape* interface
- Circle.java which is a concrete class implements *Shape*

To use above code snippet
```java
import personpkg.shapepkg.*;
```

3. I can use the interface directly in the `TestPackage.java`

4. Inside interface are all abstract methods, all methods need to be implemented. Otherwise will see:
```
$ javac TestPackage.java 
TestPackage.java:18: error: Triangle is not abstract and does not override abstract method draw() in Shape
class Triangle implements Shape {
^
1 error
```

5. Notes about run `javac`
```
~/Documents/MyCodeBase/LearnDesign/OOD/how-java-pkg-works/personpkg (master)
$ javac shapepkg/Circle.java 
shapepkg\Circle.java:3: error: cannot find symbol
public class Circle implements Shape{
                               ^     
  symbol: class Shape
1 error
```

compile 需要在package最外层才不报错
```
package personpkg.shapepkg;
```
因为`Circle`与`Shape`include的package是 **personpkg.shapepkg** 所以javac要在personpkg外层，这样根据相对路径才能找得到对应的文件

在`Person.java` 中
```java
package personpkg;

public class Person {
   private String Firstname;
   private String LastName
   ...
```
则编译要在personpkg之外

> `javac` 会自动编译相关文件，例如编译Circle.java 会自动编译 Shape.java