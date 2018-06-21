package org.vepo.user;

import java.util.List;

import javax.ws.rs.GET;

public interface UserService {

    @GET
    public List<User> list();
}