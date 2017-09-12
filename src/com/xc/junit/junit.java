package com.xc.junit;

import org.junit.Test;

import com.xc.DAO.StudentService;
import com.xc.Exception.StudentCastException;
import com.xc.bean.Student;

public class junit {
	@Test
	public void test() {
		StudentService service = new StudentService("Student.xml");
		
		try {
			service.deleteStudent("Test");
		} catch (StudentCastException e) {
			e.printStackTrace();
		}
	}
}
