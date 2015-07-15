package models;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

public class TaskSpec {

    @Before
    public void initialize() {
        Ticket.removeAll();
    }

    @Test
    public void beAddable() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                String testLabel = "Task label";
                Ticket.create(testLabel, "", "", "", "");
                    List<Ticket> tasks = Ticket.all();

                assertThat(tasks.size()).isEqualTo(1);
                assertThat(tasks.get(0).getCustomerInfo()).isEqualTo(testLabel);
            }
        });
    }

    @Test
    public void beDeletable(){
        String testLabel = "Task label";
        Ticket.create(testLabel, "", "", "", "");

        List<Ticket> tasks = Ticket.all();
        Ticket.delete(tasks.get(0).getId());

        tasks = Ticket.all();
        assertThat(tasks.size()).isEqualTo(0);
    }
}
