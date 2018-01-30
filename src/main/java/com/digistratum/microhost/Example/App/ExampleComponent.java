package com.digistratum.microhost.Example.App;

import com.digistratum.Config.Config;
import com.digistratum.microhost.RestServer.RestApiImpl;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {ExampleModule.class})
public interface ExampleComponent {
	Config getConfig();
	RestApiImpl getRestApi();
}
