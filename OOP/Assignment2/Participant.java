/****
 * @author Girdhari
 * Program to implement the scenario given in question
 * WAP to implement console based survey system
 */

import java.util.ArrayList;
import java.util.List;

/* Start of Participant class */
public class Participant {

	private int userID;
	private String userName;
	private List<String> userResponse;
	private static List<Participant> responseList = new ArrayList<Participant>();

	/* Starting of Participant constructor */
	public Participant(int participantId, String participantName) {
		this.userID = participantId;
		this.userName = participantName;
		this.userResponse = new ArrayList<String>();
	}

	/* End of Participant Constructor */

	/* Starting of getter function for ID */
	public int getParticipantId() {
		return userID;
	}

	/* End of getter function */

	/* Starting of getter function for Name */
	public String getParticipantName() {
		return userName;
	}

	/* End of getter function */

	/* starting of function doParticipantSurvey */
	public void doParticipantSurvey(String answer) {// add response into the list of the single participant
		userResponse.add(answer);
	}

	/* End of function doParticipantSurvey */

	/* Starting of doParticipantComplete function */
	public static void doParticipantComplete(Participant participant)// add response into the list of the participants
	{
		responseList.add(participant);

	}

	/* End of doParticipantComplete function */
	/* Starting of getParticipantResponse function */
	public List<String> getParticipantResponse()// get response of individuals list
	{
		return userResponse;
	}

	/* End of gerParticipantResponse function */
	/* Start of getResponseList function */
	public static List<Participant> getResponseList()// get response list of all the participants
	{
		return responseList;
	}
	/* End of getResponseList function */

}
/* End of class Participant */

