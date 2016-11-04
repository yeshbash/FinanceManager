package com.finmanager.src.manager;

import org.bson.Document;

import com.finmanager.src.constants.FinManagerConstants;
import com.finmanager.src.models.ServiceResponse;
import com.finmanager.src.models.Status;
import com.finmanager.src.service.GroupsService;
import com.finmanager.src.service.MemberService;
import com.finmanager.src.service.SequenceService;

public class GroupsManager {

	public static ServiceResponse createGroup(Document groupDoc){
		ServiceResponse response = new ServiceResponse();
		Status status = new Status();
		/*
		 * Perform input validations here
		 */
		try{
			Integer groupId = SequenceService.getNextSequence("groups");
			String creatorId = groupDoc.getString("createdBy");
			groupDoc.put("_id", groupId);
			String result = GroupsService.createGroup(groupDoc);
			if("Success".equalsIgnoreCase(result)){
				//TBD : Check if member exists
				MemberService.addMemberToGroup(creatorId, groupId.toString());
				status.setStatusCode("00");
				status.setStatusMessage("Success");
				
			}else{
				status.setStatusCode("300");
				status.setStatusMessage("Creating Group Failed");
			}
		}catch(Exception e){
			status.setStatusCode(FinManagerConstants.RESP_STATUS_CD_FAILURE);
			status.setStatusMessage(FinManagerConstants.RESP_STATUS_MSG_FAILURE);
		}
		response.setStatus(status);
		return response;
	}
	
}
