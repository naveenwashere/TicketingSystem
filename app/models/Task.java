package models;

import java.util.List;

import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.ObjectId;
import play.modules.mongodb.jackson.MongoDB;

public class Task
{
    
  @Id
  @ObjectId
  public String id;
  
  public String customerInfo;

  public String comments;
  
  public String createdBy;

  public String status;
  
  private static JacksonDBCollection<Task, String> coll = MongoDB.getCollection("tasks", Task.class, String.class);
  
  public Task()
  {

  }

  public Task(String customerInfo, String comments, String createdBy, String status) 
  {
    this.customerInfo = customerInfo;
    this.comments = comments;
    this.createdBy = createdBy;
    this.status = status;
  }

  public static List<Task> all() 
  {
    return Task.coll.find().toArray();
  }

  public static void create(Task task) 
  {
    Task.coll.save(task);
  }

  public static void create(String customerInfo, String comments, String createdBy, String status)
  {
      create(new Task(customerInfo, comments, createdBy, status));
  }

  public static void delete(String id) 
  {
    Task task = Task.coll.findOneById(id);
    if (task != null)
    {
        Task.coll.remove(task);
    }
  }

  public static void removeAll()
  {
    Task.coll.drop();
  }

}
