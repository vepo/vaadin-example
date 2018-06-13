package org.vepo.user;

import com.vaadin.ui.Notification;
import org.vepo.api.AppModule;
import org.vepo.api.ApplicationLayout;

public class UserModule implements AppModule {

    @Override
    public void register(ApplicationLayout layout) {
        ApplicationLayout.MenuOption menuOption = new ApplicationLayout.MenuOption("User");
        layout.addMenuOption(menuOption, this::optionClicked);
    }

    private void optionClicked(ApplicationLayout.MenuOption menuOption) {
        Notification.show("It works!", Notification.Type.TRAY_NOTIFICATION);
    }

}