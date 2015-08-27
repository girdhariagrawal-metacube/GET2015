/**
 * @author Girdhari
 * Main class have main method which will be an interface to user
 */

package socialnetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;


public class MainClass {
		public static void main(String args[])
		{
			BufferedReader bufferReaderObject = new BufferedReader(new InputStreamReader(System.in));
			boolean result;
			Scanner scannerObject = new Scanner(System.in);
			int input; 
			String name="";
			
				
				SocialNetwork socialNetworkObject = new SocialNetwork();
				socialNetworkObject.readPersonInformation();
				Connection connectionObject=null;
				SocialNetworkMenu socialNetworkMenu = new SocialNetworkMenu();
				Person person = null;
				Person person1 = null;
				do
				{
					socialNetworkMenu.showMenu();
					try {
					
					input = Integer.parseInt(bufferReaderObject.readLine());
					switch(input)
					{
						/* Displaying social network */
						case 1:	List<Node> nodelist=socialNetworkObject.getAdajenceyList();
						for(int index=0;index<nodelist.size();index++)
						{
							nodelist.get(index).display();
							Node node=nodelist.get(index);
							System.out.println("No of Friends are "+node.getEdgeList().size());
							for(int friendno=0;friendno<node.getEdgeList().size();friendno++)
							{
								System.out.println("Id -> "+node.getEdgeList().get(friendno).getNextNode().getData());
							}
							System.out.println();
						}
							
							break;
					
						
						/* Adding a person in social network */
						case 2:		person=readFromConsole(bufferReaderObject);
									result = socialNetworkObject.addEntitySocialNetwork(person);
									displayMessage(result);
									break;
						
						/* adding a friend in social network */
						case 3: System.out.println("Are you a new user for(Press 1)or existing user for(Press 2)");
								do
								{	
									int check=scannerObject.nextInt();
									if(check==1)
									{
										person=readFromConsole(bufferReaderObject);
										break;
									}
									else if(check==2)
									{
										System.out.println("Enter your name");
										name=bufferReaderObject.readLine();
										person=getPersonDetails(socialNetworkObject,name);
										if(person==null)
										{
											System.out.println("Name does not exist");
											continue;
										}
										break;
									}
									else
										System.out.println("Please enter correct choice");
								}while(true);
								Person friend=selectChoice(socialNetworkObject,name,bufferReaderObject);
								if(person!=null)
								{
									
									connectionObject=new Connection();
									result=connectionObject.addFriend(socialNetworkObject, person,friend);
									displayMessage(result);
								}
								break;
							
						/* removing a node */
						case 4:	
								System.out.println("Enter your name");
								name=bufferReaderObject.readLine();
								person1=getPersonDetails(socialNetworkObject, name);
								if(person1==null)
								{
									System.out.println("user does not exist");
									break;
								}
								result=socialNetworkObject.deleteNode(person1);
								displayMessage(result);
								break;
							
						/* displaying based on search */
						case 5:
								System.out.println("Enter your name");
								name=bufferReaderObject.readLine();
								person1=getPersonDetails(socialNetworkObject, name);
								if(person1==null)
								{
									System.out.println("user does not exist");
									break;
								}
								else
									person.display();
								break;
							
						/* removing an  friend  */
						case 6:
								System.out.println("Enter your name");
								name=bufferReaderObject.readLine().trim();
								person=getPersonDetails(socialNetworkObject,name);
								if(person==null)
								{
									System.out.println("Name does not exist");
									break;
								}
								else
								{
									System.out.println("Enter your friend name ");
									String friedName=bufferReaderObject.readLine().trim();
									person1=getPersonDetails(socialNetworkObject, friedName);
									if(person1==null)
									{
										System.out.println("Name does not exist");
										break;
									}
									else
									{
										connectionObject=new Connection();
										result=connectionObject.removeFriend(socialNetworkObject, person, person1);
										displayMessage(result);
										break;
									}
								}
							
							
						/* Exit */
						case 7:
								scannerObject.close();
								System.exit(0);
							
						default:
							System.out.println("Enter Right choice");
							input = Integer.parseInt(bufferReaderObject.readLine());
					}
					}
					catch(NumberFormatException nf)
					{
						System.out.println("please enter correct number");
						continue;
					}
					
					catch(IOException io)
					{
						System.out.println("Error occured please enter input again");
					}
					
				
				}while(true);
				
			
			
		}
		public static void displayMessage(boolean result)
		{
			if(result)
			{
				System.out.println("Operation successfully ");
			}
			else
			{
				System.out.println("Operation failed");
			}
		}
		public static Person readFromConsole(BufferedReader br) {
			int id=6;
			Person person=null;
			try{
				System.out.println("Enter Name");
				String name=br.readLine().trim();
				System.out.println("Enter email id");
				String emailId=br.readLine().trim();
				System.out.println("Enter you phone no");
				String phoneno=br.readLine().trim();
				System.out.println("Enter School name");
				String schoolName=br.readLine().trim();
				System.out.println("Enter College Name");
				String collegeName=br.readLine().trim();
				person= new Person(id,emailId,name,phoneno,schoolName,collegeName);
			}
			
			catch(IOException io)
			{
				System.out.println("Error please try again");
				return null;
			}
			
			return person;
			
		}
		public static Person selectChoice(SocialNetwork socialNetwork,String name,BufferedReader br) throws IOException
		{
			System.out.println("Available friend are");
			for(int index=0;index<socialNetwork.getAdajenceyList().size();index++)
			{
				Person person=socialNetwork.getNode(index);
					if(person.getName().equalsIgnoreCase(name))
						continue;
					System.out.println(person.getName());
				
			}
			System.out.println("Enter your friend name who know you");
			String friedName=br.readLine().trim();
			return getPersonDetails(socialNetwork, friedName);
			
			
		}
		public static Person getPersonDetails(SocialNetwork socialNetwork,String name)
		{
			for(int index=0;index<socialNetwork.getAdajenceyList().size();index++)
			{
				Person person=socialNetwork.getNode(index);
				if(person.getName().equalsIgnoreCase(name))
					return person;
				
			}
			return null;
		}
	}

