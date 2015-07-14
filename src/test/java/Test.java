import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		String str = "sdfsdf\\sdfsd.jpg";
		System.out.println(str.replaceAll("", "/"));

		ArrayList arr = new ArrayList();
		arr.add("f");
		arr.add("b");
		arr.add("c");
		arr.add("d");
		System.out.println(arr.indexOf("c"));
	}
}
