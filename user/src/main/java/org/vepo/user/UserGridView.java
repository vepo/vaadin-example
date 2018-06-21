package org.vepo.user;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;

public class UserGridView extends CssLayout {
	public static final String USER_GRID_VIEW = "user";

	public UserGridView() {
		try {
			URL apiUri = new URL("https://api.randomuser.me/");
			UserService userService = RestClientBuilder.newBuilder().baseUrl(apiUri).build(UserService.class);
			Grid<User> grid = new Grid<>(DataProvider.fromCallbacks(query -> userService.list().stream(),
					query -> userService.list().size()));
			// Grid<User> grid = new Grid<>(
			// 		DataProvider.ofItems(new User(1L, "vepo", "Victor"), new User(2L, "admin", "Administrator")));
			grid.addColumn(User::getId).setCaption("Id");
			grid.addColumn(User::getName).setCaption("Name");
			grid.addColumn(User::getUsername).setCaption("Username");
			this.addComponent(grid);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
