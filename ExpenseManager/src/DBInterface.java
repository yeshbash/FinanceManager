

import java.util.Date;

import org.bson.Document;

import com.finmanager.src.manager.ExpenseManager;
import com.finmanager.src.models.Expense;
import com.finmanager.src.models.ServiceResponse;
import com.google.gson.Gson;


public class DBInterface {


public static void main(String[] args) {
		
		//Creating a member
		//Member member = new Member("sswetha2809@gmail.com","Yeshwanth Bashyam","Yesh",null);
		Gson  gson = new Gson();
		//String jsonStr = gson.toJson(member);
		//Document memberDoc = Document.parse(gson.toJson(member));
		//ServiceResponse response = MemberManager.registerMember(memberDoc);
		//System.out.println(response.getStatus().getStatusCode());
		//System.out.println(createMember(memberDoc));*/
		//Creating Group
		//Group group = new Group(null,"yeshbash@gmail.com","Yeshwe Family","$");
		//ServiceResponse response = GroupsManager.createGroup(Document.parse(gson.toJson(group)));
	
		//System.out.println(response.getStatus().getStatusCode());
		
		//Adding member to a group
		/*System.out.println(addMemberToGroup("yeshbash@gmail.com", "GR5790"));
		System.out.println(addMemberToGroup("yeshbash@gmail.com", "GR5791"));*/
		
		//Updating member details
		/*member.set_id("yeshbash@gmail.com");
		member.setGroups(null);
		member.setNickName("Yeshbash");
		member.setName("Balachander,Yeshwanth Bashyam");
		System.out.println(updateMember("yeshbash@gmail.com", gson.fromJson(gson.toJson(member), Document.class)));*/
	
		//System.out.println(removeMemberFromGroup("yeshbash@gmail.com", "GR5791"));
		/*String group = "yeshbash@gmail.com";
		//	SequenceService.addSequenceId(group, 0);
		System.out.println(SequenceService.getNextSequence(group));
		System.out.println(SequenceService.getNextSequence(group));
		System.out.println(SequenceService.getNextSequence(group));
		System.out.println(SequenceService.getNextSequence(group));*/
		
		// Creating an expense
		
		Expense expense = new Expense(null,"Action Aid","Charity",52.50,new Date(),"Naanga nallavanga");
		//System.out.println(ExpenseService.addExpense("sswetha2809@gmail.com", gson.fromJson(gson.toJson(expense), Document.class)));
		//Expense expenseUpdates = new Expense(1,null,null,null,null,"Visa Double OK1!");
		ServiceResponse response = ExpenseManager.addExpense(Document.parse(gson.toJson(expense)), "yeshbash@gmail.com");
		//System.out.println(response.getStatus().getStatusCode());
		//ExpenseService.addExpense("yeshbash@gmail.com", Document.parse(gson.toJson(expense)));
		//expense.setComments("Sappa comment");
		//System.out.println(ExpenseService.updateExpense("yeshbash@gmail.com",3, Document.parse(gson.toJson(expense))));
	}
}
