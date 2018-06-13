package org.vepo.api;

import java.io.Serializable;
import java.util.Collection;

import com.vaadin.server.SerializableConsumer;
import com.vaadin.ui.Component;

public interface ApplicationLayout extends Component {
    class WorkingAreaComponent implements Serializable {

        private final String caption;
        private final Component component;

        public WorkingAreaComponent(String caption, Component component) {
            this.caption = caption;
            this.component = component;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            WorkingAreaComponent that = (WorkingAreaComponent) o;

            return caption != null ? caption.equals(that.caption) : that.caption == null;
        }

        @Override
        public int hashCode() {
            return caption != null ? caption.hashCode() : 0;
        }

        public String getCaption() {
            return caption;
        }

        public Component getComponent() {
            return component;
        }

    }

    class MenuOption implements Serializable {

        private final String caption;

        public MenuOption(String caption) {
            this.caption = caption;
        }

        public String getCaption() {
            return caption;
        }

    }

    void addHeaderComponent(Component component);

    void addWorkingAreaComponent(WorkingAreaComponent component);

    Collection<Component> getHeaderComponents();

    Collection<WorkingAreaComponent> getWorkingAreaComponents();

    void addMenuOption(MenuOption menuOption, SerializableConsumer<MenuOption> clickListener);

}
