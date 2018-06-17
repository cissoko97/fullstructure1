package org.cissoko.ckcoder;

import org.apache.catalina.LifecycleException;
import org.cissoko.ckcoder.configuration.IAppServer;
import org.cissoko.ckcoder.configuration.server.TomcatServer;

import javax.servlet.ServletException;

public class Main {
    public static void main(String[] args) throws ServletException, LifecycleException {
        IAppServer tomcat = new TomcatServer();
        tomcat.create();
        tomcat.configure();
        tomcat.start();

    }
}
