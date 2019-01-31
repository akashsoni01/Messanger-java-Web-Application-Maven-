package com.mkyong.rest.database;

import java.util.HashMap;
import java.util.Map;

import com.mkyong.rest.model.Message;
import com.mkyong.rest.model.Profile;

public class Database {
	private static Map<Long,Message> messages = new HashMap<Long, Message>();
	private static Map<Long,Profile> profiles = new HashMap<Long, Profile>();
	
	public static  Map<Long,Message> getMessage(){
		return messages;
	}
	public static Map<Long,Profile> getProfile(){
		return profiles;
	}
	
}
