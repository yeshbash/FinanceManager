package com.finmanager.src.service;

import org.bson.Document;

import com.finmanager.src.constants.FinManagerConstants;
import com.finmanager.src.utilities.MongoUtilities;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;

public class ExpenseService {

	public static long  addExpense(String id, Document expenseDoc){
		MongoDatabase db = MongoUtilities.getMongoDatabase();
		Document query = new Document("_id",id);
		Document update = new Document("$push",new Document("expenses",expenseDoc));
		UpdateOptions updateOptions = new UpdateOptions().upsert(true);
		UpdateResult result = db.getCollection(FinManagerConstants.MONGO_COLLECTIONS_EXPENSE).updateOne(query, update,updateOptions);
		return result.getModifiedCount();
	}
	
	public static long updateExpense(String id,Integer expenseId, Document expenseUpdatesDoc){
		MongoDatabase db = MongoUtilities.getMongoDatabase();
		Document query = new Document("_id",id).append("expenses.id", expenseId);
		Document update = new Document("$set",new Document("expenses.$",expenseUpdatesDoc));
		UpdateResult result = db.getCollection(FinManagerConstants.MONGO_COLLECTIONS_EXPENSE).updateOne(query, update);
		//System.out.println(result.getMatchedCount()+" : "+result.getModifiedCount());
		return result.getModifiedCount();
	}
	
	public static String addExpenseGroup(String id){
		MongoDatabase db = MongoUtilities.getMongoDatabase();
		db.getCollection(FinManagerConstants.MONGO_COLLECTIONS_EXPENSE).insertOne(new Document("_id",id));
		return "Success";
	}
}
