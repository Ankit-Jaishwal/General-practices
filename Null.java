public class Null {
public int greet() {
System.out.println("Hello world!");
return 0;
}
public static void main(String[] args) {
System.out.println(((Null) null).greet());
}
}