package models;

import java.util.Iterator;
import java.util.List;

import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.ObjectId;
import play.modules.mongodb.jackson.MongoDB;

public class Users 
{
	  @Id
	  @ObjectId
	  private String id;
	  
	  private String userName;
	  
	  private String password;

	  private static JacksonDBCollection<Users, String> coll = MongoDB.getCollection("users", Users.class, String.class);

	  public Users()
	  {

	  }

	  public Users(String userName, String passowrd) 
	  {
	    this.userName = userName;
	  }

	  public static List<Users> all() 
	  {
	    return Users.coll.find().toArray();
	  }

	  public static void create(Users users) 
	  {
	    Users.coll.save(users);
	  }

	  public static void create(String userName, String password)
	  {
	      create(new Users(userName, password));
	  }

	  public static void delete(String id) 
	  {
	    Users users = Users.coll.findOneById(id);
	    if (users != null)
	        Users.coll.remove(users);
	  }

	  public static void removeAll()
	  {
	    Users.coll.drop();
	  }

	public static boolean authenticate(String username, String password) {
		DBCursor<Users> users = Users.coll.find();
		Iterator<Users> itr = users.iterator();
		String passFromDB = null;
		while(itr.hasNext())
		{
			Users user = itr.next();
			if(user.userName.equals(username))
			{
				passFromDB = user.password;
				break;
			}
		}
		return (passFromDB.equals(password) ? true : false);		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
