package com.finmanager.src.service;

import org.bson.Document;

import com.finmanager.src.constants.FinManagerConstants;
import com.finmanager.src.utilities.MongoUtilities;
import com.mongodb.client.MongoDatabase;

public class GroupsService {
	
	public static String createGroup(Document groupDoc) {
		MongoDatabase db = MongoUtilities.getMongoDatabase();
		db.getCollection(FinManagerConstants.MONGO_COLLECTIONS_GROUPS)
				.insertOne(groupDoc);
		return "Success";
	}
	
	public static String updateGroup(String groupId, Document groupUpdatesDoc){
		MongoDatabase db = MongoUtilities.getMongoDatabase();
		Document query = new Document("_id", groupId);
		Document update = new Document("$set", groupUpdatesDoc);
		db.getCollection(FinManagerConstants.MONGO_COLLECTIONS_GROUPS)
				.updateOne(query, update);
		return "Success";
	}
}
