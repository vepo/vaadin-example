package org.vepo.webapp;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Label;
import org.vepo.api.ApplicationLayout;
import org.vepo.api.TabBasedApplicationLayout;
import org.vepo.api.AppModule;
import java.util.ServiceLoader;

@Theme("valo")
// CDIUI requires a value. 
// If you remove the value, nothing is loaded.
// If you set the empty string, it will be accessible throght http://localhost:8080
// If you set "x",  it will be accessible throght http://localhost:8080/x
@CDIUI("")
public class VaadinUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        TabBasedApplicationLayout layout = new TabBasedApplicationLayout("Caption");
        setContent(layout);
        loadModules(layout);
    }

    private void loadModules(ApplicationLayout applicationLayout) {
        ServiceLoader<AppModule> moduleLoader = ServiceLoader.load(AppModule.class);
        moduleLoader.forEach(module -> module.register(applicationLayout));
    }

}
