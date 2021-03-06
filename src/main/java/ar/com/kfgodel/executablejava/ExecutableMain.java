package ar.com.kfgodel.executablejava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tanukisoftware.wrapper.WrapperManager;

import java.io.IOException;

/**
 * Example
 * Created by kfgodel on 16/02/15.
 */
public class ExecutableMain {
    public static Logger LOG = LoggerFactory.getLogger(ExecutableMain.class);

    public static void main(String[] args) throws IOException {
        LOG.info("Example app - Replace this application jar with your own in app/executable-app.jar");

        // Hook that will tell us when the VM is shutting down, so we can free resources or whatever
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                LOG.debug("Stopped example app");
            }
        });
        
        LOG.info("Started example app");
        LOG.info("Press 'r' to restart the hosting JVM. Anything else to end the app");
        
        int readCHar = System.in.read();
        if((char)readCHar == 'r'){
            LOG.info("Restart requested");
            WrapperManager.restart();
        }else{
            LOG.info("Stop requested");
            WrapperManager.stop(0);
        }
    }
}
