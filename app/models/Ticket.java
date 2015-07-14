package models;

import java.util.List;

import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.ObjectId;
import play.modules.mongodb.jackson.MongoDB;

public class Ticket
{
    
  @Id
  @ObjectId
  public String id;
  
  public String customerInfo;

  public String comments;
  
  public String createdBy;

  public String status;
  
  public String assignTo;
  
  private static JacksonDBCollection<Ticket, String> coll = MongoDB.getCollection("tickets", Ticket.class, String.class);
  
  public Ticket()
  {

  }

  public Ticket(String customerInfo, String comments, String createdBy, String status, String assignTo) 
  {
    this.customerInfo = customerInfo;
    this.comments = comments;
    this.createdBy = createdBy;
    this.status = status;
    this.assignTo = assignTo;
  }

  public static List<Ticket> all() 
  {
    return Ticket.coll.find().toArray();
  }

  public static void create(Ticket ticket) 
  {
    Ticket.coll.save(ticket);
  }
  
  public static void update(Ticket ticket) 
  {
    Ticket.coll.update(Ticket.coll.findOneById(ticket.id), ticket);
  }

  public static void create(String customerInfo, String comments, String createdBy, String status, String assignTo)
  {
      create(new Ticket(customerInfo, comments, createdBy, status, assignTo));
  }

  public static void delete(String id) 
  {
    Ticket ticket = Ticket.coll.findOneById(id);
    if (ticket != null)
    {
        Ticket.coll.remove(ticket);
    }
  }
  
  public static Ticket findById(String id) 
  {
    return Ticket.coll.findOneById(id);
  }

  public static void removeAll()
  {
    Ticket.coll.drop();
  }

}
