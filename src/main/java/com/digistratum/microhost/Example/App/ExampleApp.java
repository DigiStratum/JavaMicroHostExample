package com.digistratum.microhost.Example.App;

import com.digistratum.Process.ProcessRunner;

import com.digistratum.microhost.App.DaggerMicroHostComponent;
import com.digistratum.microhost.App.MicroHostComponent;
import com.digistratum.microhost.App.MicroHostModule;
import com.digistratum.microhost.App.MicroHostApp;

import com.digistratum.microhost.RestServer.RestApiImpl;

public class ExampleApp {

	/*
	 * Application entry point
	 *
	 * ref: https://github.com/google/dagger/blob/master/examples/simple/src/main/java/coffee/CoffeeApp.java
	 * ref: https://medium.com/@Zhuinden/that-missing-guide-how-to-use-dagger2-ef116fbea97
	 * ref: https://github.com/raphaelbrugier/dagger2-sample
	 */
	public static void main(String[] args) {

		// Get our process runner
		MicroHostComponent microHostComponent = DaggerMicroHostComponent
				.builder()
				.microHostModule( new MicroHostModule())
				.build();
		MicroHostApp microHostApp = microHostComponent.getMicroHostApp();

		// Load up a runnable process for the Rest API Server
		ExampleComponent exampleComponent = DaggerExampleComponent.builder()
				.exampleModule(new ExampleModule())
				.build();
		RestApiImpl restApiImpl = exampleComponent.getRestApi();
		microHostApp.load(restApiImpl);

		new ExampleApp(microHostApp);
	}

	/**
	 * Constructor
	 *
	 * Starts our service application using Constructor injection
	 *
	 * @param processRunner ProcessRunner instance which is ready to run
	 */
	public ExampleApp(ProcessRunner processRunner) {

		// Start our loaded runnable processes
		processRunner.run();
	}
}
