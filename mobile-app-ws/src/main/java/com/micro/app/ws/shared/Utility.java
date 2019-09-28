package com.micro.app.ws.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;
@Service
public class Utility {

	public String getRandomUUID() {
		return UUID.randomUUID().toString();
	}

}
