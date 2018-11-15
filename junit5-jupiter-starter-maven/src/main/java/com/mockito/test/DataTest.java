package com.mockito.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * 
 * @author BIRENDRA KUMAR SHAW
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class DataTest {

	@Mock
	DataSource dsMock;

	@InjectMocks
	DataService serviceMock;

	@BeforeEach
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getTotal() {
		/**
		 * In Service class mainly we called DAO class method, here we are saying that
		 * whenever DAO method will be called from service thenReturn(our expected DB
		 * data->(same data that we will get by hitting DB) )
		 * 
		 */
		
		/**
		  Consider this as a original DB Data.
		*/
		List<Integer> ourExpectedDBData = Stream.of(2, 5).collect(Collectors.toList());
		
		when(dsMock.dbData()).thenReturn(ourExpectedDBData);
		/**
		 * Here,we calling service method which internally will call DAO method,for DAO
		 * method we already have our expected DB data,so service will perform logic
		 * based on our expected DB data.
		 * 
		 * if after the service class logics,the expected output is equal to the actual
		 * output that service class will return then test "SUCCESS" else test "FAILS".
		 */
		long expected = 7;
		assertEquals(expected, serviceMock.getTotal());
	}
}
