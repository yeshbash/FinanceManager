package com.finmanager.src.service;

import org.bson.Document;

import com.finmanager.src.constants.FinManagerConstants;
import com.finmanager.src.utilities.MongoUtilities;
import com.mongodb.client.MongoDatabase;

public class SequenceService {

	public static Integer getNextSequence(String id){
		MongoDatabase db = MongoUtilities.getMongoDatabase();
		Document seq = new Document("seq",1);
		Document increment = new Document("$inc",seq);
		Document doc = db.getCollection(FinManagerConstants.MONGO_COLLECTIONS_SEQUENCE).
			findOneAndUpdate(new Document("_id",id), increment);
		return doc.getInteger("seq");
	}
	
	public static boolean addSequenceId(String id,Integer seqBase){
		MongoDatabase db = MongoUtilities.getMongoDatabase();
		Document seq = new Document("_id",id).append("seq", seqBase);
		db.getCollection(FinManagerConstants.MONGO_COLLECTIONS_SEQUENCE).insertOne(seq);
		return true;
	}
	
	public static boolean removeSequnceId(String id){
		MongoDatabase db = MongoUtilities.getMongoDatabase();
		Document seq = new Document("_id",id);
		db.getCollection(FinManagerConstants.MONGO_COLLECTIONS_SEQUENCE).deleteOne(seq);
		return true;
	}
}
