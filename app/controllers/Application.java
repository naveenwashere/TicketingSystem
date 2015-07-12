package controllers;

import models.Ticket;
import models.Users;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;


public class Application extends Controller {
  static Form<Ticket> ticketForm = Form.form(Ticket.class); 
  
  public static Result index() 
  {
    return redirect(routes.Application.tickets());
  }
  
  public static Result tickets() 
  {
    return ok(
      views.html.index.render(Ticket.all(), ticketForm)
    );
  }
  
  public static Result users() 
  {
    return ok(
      Json.toJson(Users.all())
    );
  }
  
  public static Result assign() 
  {
	  
	  Form<Ticket> filledForm = ticketForm.bindFromRequest();
      if(filledForm.hasErrors()) 
      {
        return badRequest(
          views.html.index.render(Ticket.all(), filledForm)
        );
      } 
      else 
      {
        Ticket.update(filledForm.get());
        return redirect(routes.Application.tickets());  
      }
	  
  }
  
  public static Result newTicket() 
  {
    Form<Ticket> filledForm = ticketForm.bindFromRequest();
      if(filledForm.hasErrors()) 
      {
        return badRequest(
          views.html.index.render(Ticket.all(), filledForm)
        );
      } 
      else 
      {
        Ticket.create(filledForm.get());
        return redirect(routes.Application.tickets());  
      }
  }
  
  public static Result deleteTicket(String id) 
  {
    Ticket.delete(id);
    return redirect(routes.Application.tickets());
  }

}
