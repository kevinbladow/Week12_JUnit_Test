package com.promineotech;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class TestDemoJUnitTest {

	private TestDemo testDemo; 
	
		
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	// test the method with four arguments as input parameters
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException ) {
		//if the expected output is "true" (no exception expected) then, execute the test.
		if(!expectException) {
			assertThat(testDemo.addPositive(a,b)).isEqualTo(expected);  
		} else assertThatThrownBy(() -> testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class);
	}
	
	static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(
				arguments(2,4,6, false),
				arguments(0, 1, 1, true),
				arguments(1, 0, 1, true),
				arguments(1, -1, 0, true),
				arguments(-1, 1, 0, true),
				arguments(-2, -2, -4, true),
				arguments(0, -1, -1, true),
				arguments(-1, 0, -1, true));
				
	}// end method
	
	@Test 
	protected void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	}
	
	@Test
	protected void assertThatBlanksInStringAreCountedCorrectly() {
		assertThat(testDemo.countSpaces("This is the string to test") == 5);
		assertThat(testDemo.countSpaces("trythisone") == 0);
	}
	
	@Test
	protected void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();	//sets the expected return value of 5 for the random number generator
		int fiveSquared = mockDemo.randomNumberSquared();   //calls the randomNumberSquared method with the mocked input of 5
		assertThat(fiveSquared).isEqualTo(25);	//asserts that the result of the method call should be 25
	}
}
