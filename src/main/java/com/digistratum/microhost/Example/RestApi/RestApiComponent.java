package com.digistratum.microhost.Example.RestApi;

import com.digistratum.Config.Config;
import com.digistratum.microhost.RestServer.RestApiImpl;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {RestApiModule.class})
public interface RestApiComponent {
	Config getConfig();
	RestApiImpl getRestApi();
}
