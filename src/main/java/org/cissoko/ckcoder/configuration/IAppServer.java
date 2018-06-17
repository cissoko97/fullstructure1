package org.cissoko.ckcoder.configuration;

import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;

public interface IAppServer {
    void create();

    void configure() throws ServletException;

    void start() throws LifecycleException;

    void stop() throws LifecycleException;
}
