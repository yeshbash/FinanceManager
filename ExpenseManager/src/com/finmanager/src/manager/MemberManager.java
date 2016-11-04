package com.finmanager.src.manager;

import org.bson.Document;

import com.finmanager.src.constants.FinManagerConstants;
import com.finmanager.src.models.ServiceResponse;
import com.finmanager.src.models.Status;
import com.finmanager.src.service.ExpenseService;
import com.finmanager.src.service.MemberService;
import com.finmanager.src.service.SequenceService;

public class MemberManager {

	public static ServiceResponse registerMember(Document memberDoc){
		ServiceResponse response = new ServiceResponse();
		/*
		 * Validations to be done
		 */
		String memberId = memberDoc.getString("_id");
		try{
			String result = MemberService.createMember(memberDoc);
			if("Success".equalsIgnoreCase(result)){
				SequenceService.addSequenceId(memberId,1);
				ExpenseService.addExpenseGroup(memberId);
				response.setStatus(new Status("00","Success",null));
				
			}
		}catch(Exception e){
			response.setStatus(new Status(FinManagerConstants.RESP_STATUS_CD_FAILURE,e.getMessage(),null));
		}
		return response;
	}
	
	public static ServiceResponse addMemberToGroup(String memberId, String groupId){
		ServiceResponse response = new ServiceResponse();
		Status status = new Status();
		/*
		 * Validations to be done
		 */
		try{
			//TBD - Check if memberId exist in Member Collection
			Long updates = MemberService.addMemberToGroup(memberId, groupId);
			if(updates ==0){
				status.setStatusCode("200");
				status.setStatusMessage("Warning : No Updates made");
			}else{
				status.setStatusCode("00");
				status.setStatusMessage("Success");
			}
		}catch(Exception e){
			status.setStatusCode(FinManagerConstants.RESP_STATUS_CD_FAILURE);
			status.setStatusMessage(FinManagerConstants.RESP_STATUS_MSG_FAILURE);
		}
		return response;
	}
}
