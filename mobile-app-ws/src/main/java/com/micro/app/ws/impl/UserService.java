package com.micro.app.ws.impl;

import com.micro.app.ws.model.UserDetails;
import com.micro.app.ws.request.mapper.UserRequest;

public interface UserService {
	public UserDetails createUser(UserRequest requsst);
}
