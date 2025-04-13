package my.day14.multi_inheritance;

import my.day14.overiding.Child;
import my.day14.overiding.Parent;

public class Test3 implements Test1,Test2{
	public String abc() {
		Parent child = new Child();
		return child.toString();
	}
}
