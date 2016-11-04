package com.finmanager.src.manager;

import org.bson.Document;

import com.finmanager.src.models.ServiceResponse;
import com.finmanager.src.models.Status;
import com.finmanager.src.service.ExpenseService;
import com.finmanager.src.service.SequenceService;

public class ExpenseManager {
	
	public static ServiceResponse addExpense(Document expenseDoc, String id){
		boolean validMessge = true;
		ServiceResponse response = new ServiceResponse();
		Status status = new Status();
		
		if(id!=null && id.contains("@")){
			//TBD - Validate if valid Member
		}else{
			//TBD - Validate if valid Group
		}
		try{
			if(validMessge){
				Integer expenseId = SequenceService.getNextSequence(id);
				expenseDoc.put("id", expenseId);
				long result = ExpenseService.addExpense(id, expenseDoc);
				if(result>0){
					status.setStatusCode("00");
					status.setStatusMessage("Success");
				}else{
					status.setStatusCode("300");
					status.setStatusMessage("Failure in adding expense");
				}
			}else{
				status.setStatusCode("100");
				status.setStatusMessage("Validation Error");
			}
		}catch(Exception e){
			status.setStatusCode("400");
			status.setStatusMessage(e.getMessage());
		}
		response.setStatus(status);
		return response;
	}
}
