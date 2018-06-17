package org.cissoko.ckcoder.configuration.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.apache.tomcat.util.scan.Constants;
import org.cissoko.ckcoder.configuration.IAppServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import java.io.File;

public class TomcatServer implements IAppServer {
    private Tomcat tomcat;
    private static String dir = "src/main/webapp/";
    private Logger logger = LoggerFactory.getLogger(TomcatServer.class);

    @Override
    public void create() {
        System.setProperty(Constants.SKIP_JARS_PROPERTY, "*.jar");
        tomcat = new Tomcat();
        String portEnv = System.getenv("server.port");
        if (portEnv == null)
            tomcat.setPort(8090);
        else {
            int port = Integer.parseInt(portEnv);
            tomcat.setPort(port);
        }
    }

    @Override
    public void configure() throws ServletException {
        tomcat.getConnector();

        Context context = tomcat.addWebapp("", new File(dir).getAbsolutePath());
        File classDir = new File("out/production/classes");
        WebResourceRoot resourceRoot = new StandardRoot(context);

        resourceRoot.addPreResources(new DirResourceSet(resourceRoot, "/WEB-INF/classes", classDir.getAbsolutePath(), "/"));

        context.setResources(resourceRoot);
    }

    @Override
    public void start() throws LifecycleException {
        tomcat.start();
        tomcat.getServer().await();
    }

    @Override
    public void stop() throws LifecycleException {
        tomcat.stop();
    }
}
