package Grupo11.FrameworkTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import junit.framework.TestCase;
import junit.framework.TestResult;
import Grupo11.FrameworkTest.Assertions;

public class TestSuite {
	private Collection<TestCase> tests;
	private Collection<Boolean> testResults;
	
	public TestSuite(){
		tests = new ArrayList<TestCase>();
		testResults = new ArrayList<Boolean>();
	};
	
	public void runAll(){
		for(TestCase test:tests){
			test.run();
		}
	}
	
	public void addTestCase(TestCase test){
		tests.add(test);
	}
	
	public void showTestCase(){
		for(Boolean testResult:testResults){
			if (testResult){
				//los test tienen que tener nombre
				System.out.println("El test paso correctamente");
			}else{
				System.out.println("El test fallo correctamente");
			}
				
		}
	}

}