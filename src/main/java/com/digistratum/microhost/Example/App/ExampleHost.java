package com.digistratum.microhost.Example.App;

import com.digistratum.Process.ProcessRunner;

import com.digistratum.microhost.App.DaggerMicroHostComponent;
import com.digistratum.microhost.App.MicroHostComponent;
import com.digistratum.microhost.App.MicroHostModule;
import com.digistratum.microhost.App.MicroHostApp;

import com.digistratum.microhost.RestServer.DaggerRestApiComponent;
import com.digistratum.microhost.RestServer.RestApiImpl;

import com.digistratum.microhost.Example.RestApi.RestApiModule;
import com.digistratum.microhost.Example.RestApi.RestApiComponent;

public class ExampleHost {

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
		RestApiComponent restApiComponent = DaggerRestApiComponent.builder()
				.restApiModule( new RestApiModule())
				.build();
		RestApiImpl restApiImpl = restApiComponent.getRestApi();
		microHostApp.load(restApiImpl);

		new ExampleHost(microHostApp);
	}

	/**
	 * Constructor
	 *
	 * Starts our service application using Constructor injection
	 *
	 * @param processRunner ProcessRunner instance which is ready to run
	 */
	public ExampleHost(ProcessRunner processRunner) {

		// Start our loaded runnable processes
		processRunner.run();
	}
}
