/****
 * @author Girdhari
 * Program to implement the scenario given in question
 * WAP to implement console based survey system
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/*Starting of class SurveyApplication*/
public class SurveyApplicationMain {
	/* Starting of main method */
	public static void main(String args[]) {
		int noOfUsers = 0;
		int id = 1;
		List<Questions> questionList = Questions.readQuestionsFromFile();// List of question that contain question object
		int noOfQuestion = questionList.size();
		Participant participantReference = null;
		Questions question = null;
		BufferedReader bufferReaderObj = new BufferedReader(
				new InputStreamReader(System.in));// Reading input from keyboard
		try {

			while (true) {
				System.out.println("Enter your name");
				String name = bufferReaderObj.readLine();
				System.out.println("Your Name is " + name + " And ID is "
						+ id++);
				participantReference = new Participant(id, name);
				for (int index = 0; index < noOfQuestion; index++) {
					question = questionList.get(index);
					System.out.println(question.getQuestion()
							+ question.getQuestionType()
							+ question.getOptions());// Display specific question
					String response = readResponse(bufferReaderObj, question);// read response from keyboard
					participantReference.doParticipantSurvey(response); // put the response by method doParticipantSurvey
				}
				Participant.doParticipantComplete(participantReference);
				noOfUsers++;
				int isContinue = 0;
				boolean flag = false;
				do {
					System.out
							.println("Any other participant are left press 1 for continue and no for press 0");
					try {
						isContinue = Integer.parseInt(bufferReaderObj
								.readLine());// read if further participant are continue
					} catch (NumberFormatException nf) {
						System.out.println("Please enter 1 or 0");
						continue;
					} catch (IOException io) {
						System.out
								.println("error occured please enter input again");
						continue;
					}
					if (isContinue == 1)
						break;
					if (isContinue == 0) {
						flag = true;
						break;
					}
				} while (true);

				if (flag)
					break;
			}
			/* For giving rating in percentage or overall rating */

			int rating[] = overallRating(questionList);
			System.out.println("Rating are for single select");
			for (int index = 0; index < rating.length; index++)
				System.out.println(index + 1 + "->" + rating[index]);
			/* Display response given by participant */
			List<Participant> responseList = Participant.getResponseList();
			List<String> response = null;
			for (int index = 0; index < noOfUsers; index++) { /*Print the response of each participants with questions */
				participantReference = responseList.get(index);
				System.out.println("Participant Id is "
						+ participantReference.getParticipantId());
				System.out.println("Participant Name is "
						+ participantReference.getParticipantName());
				response = participantReference.getParticipantResponse();
				for (int index1 = 0; index1 < noOfQuestion; index1++) {
					question = questionList.get(index1);
					System.out.println(question.getQuestion()
							+ question.getQuestionType()
							+ question.getOptions());
					System.out.println(response.get(index1));
				}
			}

			bufferReaderObj.close();
		} catch (NumberFormatException nf) {
			System.out.println("Please enter no in format");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Input exception");
			System.exit(1);
		} catch (ArrayIndexOutOfBoundsException rr) {
			System.out.println("array index out of bound exception");
			System.exit(1);

		}
	}

	/* Ending of main method */
	/* Starting of checkResponse function */
	public static boolean checkResponse(Questions question, String response)// Check response is given is correct format or not
	{
		String questionType = question.getQuestionType();
		String splitString[] = null;
		String splitStringResponse[] = null;
		String questionOptions = question.getOptions();
		if (questionType.equalsIgnoreCase("Text")) {
			return true;
		}
		splitString = questionOptions.split("/");
		int size = splitString.length;
		splitString[0] = splitString[0].substring(1, splitString[0].length());
		splitString[size - 1] = splitString[size - 1].substring(0,
				splitString[size - 1].length());
		if (questionType.equalsIgnoreCase("Multi Select")) {
			splitStringResponse = response.split("/");
			for (int index = 0; index < splitStringResponse.length; index++) {
				if (checkCorrectResponse(splitString,
						splitStringResponse[index]))
					;

				else {
					return false;
				}
			}
			return true;

		} else if (questionType.equalsIgnoreCase("Single Select")) {
			return checkCorrectResponse(splitString, response);
		}
		return false;
	}

	/* End of checkResponse function */
	/* Starting of function readResponse */
	public static String readResponse(BufferedReader br, Questions question) // Read response from keyboard
	{
		String response = "";
		try {
			response = br.readLine();
		} catch (IOException io) {
			System.out.println("error occured please enter again");
			readResponse(br, question);
		}
		if (response == "" || response == null) {
			System.out.println("Please eneter valid response1");
			readResponse(br, question);
		}
		boolean isCorrect = checkResponse(question, response);
		if (!isCorrect) {
			System.out.println("Please enter valid response2");
			readResponse(br, question);
		}
		return response;
	}

	/* End of function readResponse */

	/* Start of OverallRating function */
	public static int[] overallRating(List<Questions> questionList) // Generate rating of given option
	{
		int rating[] = new int[5];
		int index = 0, total = 0;
		for (index = 0; index < questionList.size(); index++) {
			boolean isSingle = questionList.get(index).getQuestionType()
					.equalsIgnoreCase("Single Select");
			if (isSingle)
				break;
		}
		for (int counter = 0; counter < Participant.getResponseList().size(); counter++) {
			String output = Participant.getResponseList().get(counter)
					.getParticipantResponse().get(index);
			int convert = Integer.parseInt(output);
			rating[convert - 1]++;
			total++;

		}
		for (index = 0; index < rating.length; index++) {
			rating[index] = (rating[index] * 100) / total;
		}
		return rating;

	}

	/* End of OverallRating function */
	/* Start of checkCorrectResponse function */
	public static boolean checkCorrectResponse(String splitString[],
			String response) // Check if response is correct response or not
	{
		for (int index = 0; index < splitString.length; index++) {
			if (splitString[index].equalsIgnoreCase(response)) {
				return true;
			}
		}
		return false;
	}
	/* End of checkCorrectResponse function */
}
/* Ending of surveyApplication class */
