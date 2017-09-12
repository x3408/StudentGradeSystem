package com.xc.DAO;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.xc.Exception.StudentCastException;
import com.xc.bean.Student;
import com.xc.util.XMLHelper;

public class StudentService {
	private String path;
	private XMLHelper helper;
	public StudentService(String path) {
		this.path = path;
		helper = XMLHelper.getInstance();
	}
	
	
	public void addStudent(Student stu) {
		try{
			Document document = helper.getDocument(path);
			
			Node student = document.createElement("Student");
			
			Node name = document.createElement("name");
			name.setTextContent(stu.getName());
			
			Node id = document.createElement("id");
			id.setTextContent(stu.getId()+"");
			
			Node grade = document.createElement("grade");
			grade.setTextContent(stu.getGrade()+"");
			
			Node root = document.getElementsByTagName("System").item(0);
			student.appendChild(name);
			student.appendChild(id);
			student.appendChild(grade);
			root.appendChild(student);
			
			helper.writeToFile(document);
			return;	
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void deleteStudent(String name) throws StudentCastException{
		try {
			Document document = helper.getDocument(path);
			NodeList list = document.getElementsByTagName("name");
			for(int i=0;i<list.getLength();i++) {
				if(list.item(i).getTextContent().equals(name)) {
					list.item(i).getParentNode().getParentNode().removeChild(list.item(i).getParentNode());
					helper.writeToFile(document);
					return;
				}
			}
			throw new StudentCastException();
		} catch (StudentCastException se) {
			throw se;
		} catch (Exception e){
			throw new RuntimeException();
		}
	}
}
