package com.finmanager.src.service;

import org.bson.Document;

import com.finmanager.src.constants.FinManagerConstants;
import com.finmanager.src.utilities.MongoUtilities;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

public class MemberService {

	public static String createMember(Document memberDoc) {
		MongoDatabase db = MongoUtilities.getMongoDatabase();
		db.getCollection(FinManagerConstants.MONGO_COLLECTIONS_MEMBERS)
				.insertOne(memberDoc);
		return "Success";
	}

	public static long addMemberToGroup(String memberId, String groupId) {
		MongoDatabase db = MongoUtilities.getMongoDatabase();
		Document query = new Document("_id", memberId);
		Document update = new Document("$push", new Document("groups", groupId));
		UpdateResult result = db.getCollection(FinManagerConstants.MONGO_COLLECTIONS_MEMBERS)
				.updateOne(query, update);
		return result.getModifiedCount();
	}

	public static long removeMemberFromGroup(String memberId, String groupId) {
		MongoDatabase db = MongoUtilities.getMongoDatabase();
		Document query = new Document("_id", memberId);
		Document update = new Document("$pop", new Document("groups", groupId));
		UpdateResult result = db.getCollection(FinManagerConstants.MONGO_COLLECTIONS_MEMBERS)
				.updateOne(query, update);
		return result.getModifiedCount();
	}
	
	public static long updateMember(String memberId, Document memberUpdatesDoc){
		MongoDatabase db = MongoUtilities.getMongoDatabase();
		Document query = new Document("_id", memberId);
		Document update = new Document("$set", memberUpdatesDoc);
		UpdateResult result = db.getCollection(FinManagerConstants.MONGO_COLLECTIONS_MEMBERS)
				.updateOne(query, update);
		return result.getModifiedCount();
	}
	
}
