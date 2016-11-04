package com.finmanager.src.utilities;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoUtilities {

	private static String databaseName;
	private static MongoClient client;
	private static MongoDatabase db;
	
	static{
		databaseName = "local";
		client = new MongoClient();
		db = client.getDatabase(databaseName);
	}
	public static MongoDatabase getMongoDatabase(){
		return db;
	}
	
	public static boolean closeMongoClient(){
		client.close();
		return true;
	}
}
