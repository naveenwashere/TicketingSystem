package models;

import java.util.List;

import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.ObjectId;
import play.modules.mongodb.jackson.MongoDB;

public class Users 
{
	  @Id
	  @ObjectId
	  public String id;
	  
	  public String userName;

	  private static JacksonDBCollection<Users, String> coll = MongoDB.getCollection("users", Users.class, String.class);

	  public Users()
	  {

	  }

	  public Users(String userName) 
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

	  public static void create(String userName)
	  {
	      create(new Users(userName));
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


}
