package de.timmeey.bastel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.pippo.controller.ControllerApplication;

/**
 * A simple Pippo application.
 *
 * @see de.timmeey.bastel.PippoLauncher#main(String[])
 */
public class PippoApplication extends ControllerApplication {

    private final static Logger log = LoggerFactory.getLogger(PippoApplication.class);

    @Override
    protected void onInit() {
        addControllers(new DemoController(this.getErrorHandler())); // one instance for ALL requests

    }

}
