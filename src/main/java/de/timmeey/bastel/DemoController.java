package de.timmeey.bastel;

import ro.pippo.controller.Controller;
import ro.pippo.controller.GET;
import ro.pippo.core.ErrorHandler;

/**
 * DemoController.
 * @author Tim Hinkes (timmeey@timmeey.de)
 * @version $Id:\$
 */
public class DemoController extends Controller {
    public DemoController(ErrorHandler errorHandler) {

        //this sets all exceptionHandler for exceptions specific to this controller.
        //global exceptionHandlers will be set during setup of the application

        //Handler that transformes a DemoException into a 404 NOT FOUND
        errorHandler.setExceptionHandler(SomethingNotFoundException.class, (exception, routeContext) -> {
            SomethingNotFoundException castedException = (SomethingNotFoundException) exception;
            getRouteContext().setLocal("message", "Some errorText");
            errorHandler.handle(404, routeContext);
        });
    }

    //Controller Method that can throw exceptions
    @GET("/demo")
    public String demo() throws SomethingNotFoundException {
        // send a file as response
        return getHello();
    }

    //Some method that could throw exceptions
    public String getHello() throws SomethingNotFoundException {
        throw new SomethingNotFoundException("Hello was not found");
    }

    private class SomethingNotFoundException extends Exception{
        public SomethingNotFoundException(final String message) {
            super(message);
        }
    }

}
