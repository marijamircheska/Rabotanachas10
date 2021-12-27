package zad3;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLCreator {
	public void createXMLFile(String fileName, List<Student> student) {
		try {
			//�������� �� ��������
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();

			//�������� �� root ���������
			Element root = document.createElement("Studenti");
			document.appendChild(root);

			for (int i=0;i<student.size();i++) {
				//�������� �� ��������� - Student (��� ������� �� �� �������� �� root ���������)
				Element studentElement = document.createElement("Student");
				root.appendChild(studentElement);
				
				// So metodot setAttribute se dodavaat atributi na elementite
				//setAttribute prima dva argumenti - stringovi, od koj prviot e ime na atributot, vtoriot vrednosta
				studentElement.setAttribute("id",String.valueOf(i));

				//�������� �������� �� �� ������� �� ��������� Student
				//�������� �� ��������� - Ime
				Element ime =  document.createElement("Ime");
				studentElement.appendChild(ime);

				//�������� �� ��������� - Prezime
				Element prezime = document.createElement("Prezime");
				studentElement.appendChild(prezime);

				//�������� �� ��������� - Index
				Element index = document.createElement("Index");
				studentElement.appendChild(index);

				//���������� ���������
				ime.appendChild(document.createTextNode(student.get(i).getIme()));
				prezime.appendChild(document.createTextNode(student.get(i).getPrezime()));
				index.appendChild(document.createTextNode(String.valueOf(student.get(i).getIndex())));
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);

			StreamResult result = new StreamResult(new File(fileName));

			transformer.transform(source, result);
			System.out.println("Fajlot e kreiran, imeto e: "+ fileName);

			System.out.println("Fajlot e zachuvan.");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}