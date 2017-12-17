 class Point {
final int x, y;
final String name;
Point (int X, int Y) {
x=X;y=Y;
name = makeN();
}
String makeN() {
return "["+x+","+y+"]";
}
public final String toString() {
return name;
}

public static void main(String[] args) {
	Point point = new Point(1, 2);
	System.out.println(point.makeN());
}
}