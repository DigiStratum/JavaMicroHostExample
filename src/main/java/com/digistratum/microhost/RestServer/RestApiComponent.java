package com.digistratum.microhost.RestServer;

import com.digistratum.Config.Config;
import com.digistratum.microhost.Example.Api.RestApiModule;
import com.digistratum.Process.MHRunnable;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {RestApiModule.class})
public interface RestApiComponent {
	Config getConfig();
	MHRunnable getRestApi();
}
