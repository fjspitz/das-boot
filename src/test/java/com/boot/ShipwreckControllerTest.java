package com.boot;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipWreckRepository;

public class ShipwreckControllerTest {
	
	@InjectMocks
	ShipwreckController sc;
	
	@Mock
	private ShipWreckRepository shipwreckRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipwreckGet() {
		Shipwreck s = new Shipwreck();
		s.setId(1L);
		
		Optional<Shipwreck> sw = Optional.of(s);

		when(shipwreckRepository.findById(1L)).thenReturn(sw);
		//when(shipwreckRepository.findOne(1L)).thenReturn(sw);
		
		Shipwreck wreck = sc.get(1L);
		assertEquals(1L, wreck.getId().longValue());
	}
}
