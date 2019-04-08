package com.javafullstackdev.demo.mapper;

import org.modelmapper.PropertyMap;

import com.javafullstackdev.demo.dto.UserDTO;
import com.javafullstackdev.demo.entity.User;

public class UserSkipPropertiesMapper extends PropertyMap<User, UserDTO>{

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		skip(destination.getMailingAddress());
	}

}
