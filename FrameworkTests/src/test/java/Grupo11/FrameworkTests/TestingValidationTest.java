package Grupo11.FrameworkTests;

import static org.junit.Assert.*;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.Validation;

import org.junit.Before;
import org.junit.Test;

public class TestingValidationTest {

	@Test
	public void testValidateTrue() {
		Boolean condicion = true;
		Validation.validateTrue(condicion);
		assertTrue(condicion);
	}

	@Test
	public void testValidateFalse() {
		Boolean condicion = false;
		Validation.validateFalse(condicion);
		assertFalse(condicion);
	}

	@Test
	public void testValidateEqualsObjectObject(){
		Object obj1 = new Object();
		Object obj2 = new Object();
		obj2 = obj1;
		
		Validation.validateEquals(obj1, obj2);
		assertEquals(obj1, obj2);
	}

	@Test
	public void testValidateEqualsBooleanBoolean() {
		Boolean condicion1 = true;
		Boolean condicion2 = true;
		Validation.validateEquals(condicion1, condicion2);
		assertEquals(condicion1, condicion2);
	}

	@Test
	public void testValidateEqualsIntInt() {
		int condicion1 = 1;
		int condicion2 = 1;
		Validation.validateEquals(condicion1, condicion2);
		assertEquals(condicion1, condicion2);

	}

	@Test
	public void testValidateEqualsShortShort() {
		short condicion1 = 1;
		short condicion2 = 1;
		Validation.validateEquals(condicion1, condicion2);
		assertEquals(condicion1, condicion2);

	}

	@Test
	public void testValidateEqualsLongLong() {
		long condicion1 = 1;
		long condicion2 = 1;
		Validation.validateEquals(condicion1, condicion2);
		assertEquals(condicion1, condicion2);

	}

	@Test
	public void testValidateEqualsFloatFloat() {
		float condicion1 = (float) 1.8;
		float condicion2 = (float) 1.8;
		Validation.validateEquals(condicion1, condicion2);
		assertEquals(condicion1, condicion2, 0);

	}

	@Test
	public void testValidateEqualsDoubleDouble() {
		double condicion1 = 1.3;
		double condicion2 = 1.3;
		Validation.validateEquals(condicion1, condicion2);
		assertEquals(condicion1, condicion2, 0);

	}

	@Test
	public void testValidateEqualsByteByte() {
		byte condicion1 = 1;
		byte condicion2 = 1;
		Validation.validateEquals(condicion1, condicion2);
		assertEquals(condicion1, condicion2);

	}

	@Test
	public void testValidateEqualsCharChar() {
		char condicion1 = 'a';
		char condicion2 = 'a';
		Validation.validateEquals(condicion1, condicion2);
		assertEquals(condicion1, condicion2);

	}

	@Test
	public void testValidateNull() {
		int[] soyNull = null;
		Validation.validateNull(soyNull);
		assertNull(soyNull);
	}
	

}
