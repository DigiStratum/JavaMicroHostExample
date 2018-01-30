package com.digistratum.microhost.Example;

import com.digistratum.microhost.App.MicroHostApp;
import com.digistratum.microhost.Example.App.ExampleApp;
import com.digistratum.microhost.RestServer.RestApiImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * ref: FAIL: https://stackoverflow.com/questions/16570029/mockito-mock-objects-returns-null
 * ref: https://medium.com/@fabioCollini/android-testing-using-dagger-2-mockito-and-a-custom-junit-rule-c8487ed01b56
 * ref: https://github.com/fabioCollini/DaggerMock
 *
 * @FIXME Figure out how to get MockitoJUnitTestRunner plus @Mock and @InjectMocks to do the mocking for us!
 */
public class ExampleAppTest {
	private ExampleApp sut;

	private RestApiImpl mockRestApiImpl;
	private MicroHostApp mockMicroHostApp;

	@BeforeEach
	public void setup() throws Exception {
		//mockRestApiImpl = mock(RestApiImpl.class);
		mockMicroHostApp = mock(MicroHostApp.class);
		sut = new ExampleApp(mockMicroHostApp);
	}

	@Test
	public void testThatExampleHostStartsApi() {
		verify(mockMicroHostApp, times(1)).run();
	}
}