package Pojos;

	/*
	 	POJO: Plain Old Java Object.
	 	POJO is a class.
	 	To create PJO Class we need to do followings;
		 	1)Create "private" variables for every key of JSON Data
		 	2)Create all getters and setters for the private variables
		 	3)Create Constructor without parameter
		 	4)Create Constructor with all parameters
		 	5)Create toString() 
	*/

	/*
	 	 {
		    "userId": 10,
		    "id": 198,
		    "title": "quis eius est sint explicabo",
		    "completed": true
         }
	 */
public class TodosPojo {
	
	//1)Create "private" variables for every key of JSON Data
	private int userId;
	private int id;
	private String title;
	private boolean completed;
	
	//2)Create all getters and setters for the private variables
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	//3)Create Constructor without parameter (Remove super();) 
	public TodosPojo() {
		
	}
	
	//4)Create Constructor with all parameters (Remove super();)
	public TodosPojo(int userId, int id, String title, boolean completed) {
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.completed = completed;
	}
	
	//5)Create toString() 
	@Override
	public String toString() {
		return "TodosPojo [userId=" + userId + ", id=" + id + ", title=" + title + ", completed=" + completed + "]";
	}


}
