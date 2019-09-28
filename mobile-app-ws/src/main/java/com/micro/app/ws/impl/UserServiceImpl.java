package com.micro.app.ws.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.app.ws.model.UserDetails;
import com.micro.app.ws.request.mapper.UserRequest;
import com.micro.app.ws.shared.Utility;

@Service
public class UserServiceImpl implements UserService {
	Map<String, UserDetails> users;
	Utility utility;

	public UserServiceImpl() {
	}

	@Autowired
	public UserServiceImpl(Utility utility) {
		this.utility = utility;
	}

	@Override
	public UserDetails createUser(UserRequest userRequest) {
		UserDetails details = new UserDetails(userRequest.getFirstName(), userRequest.getLastName(),
				userRequest.getEmail(), "");
		String userId = utility.getRandomUUID();
		details.setUserId(userId);
		if (null == users)
			users = new HashMap<>();
		users.put(userId, details);
		return details;
	}

}
