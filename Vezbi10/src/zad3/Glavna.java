package zad3;

import java.util.ArrayList;
import java.util.List;

public class Glavna {

	public static void main(String[] args) {
		XMLCreator xml = new XMLCreator();
		List<Student> s = new ArrayList<Student>();
		s.add(new Student("Marija", "Mircheska", 774));
		xml.createXMLFile("xml.xml", s);
	}
}
