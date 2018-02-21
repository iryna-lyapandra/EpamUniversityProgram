package workflow;

public class Resolved implements State {
    private Task task;

    public Resolved (Task task){
        this.task = task;
    }
    public void close(){
        task.setState(new Closed(task));
        System.out.println("Successfully closed the task");
    }
    public void reopen(){
        task.setState(new Reopened(task));
        System.out.println("Successfully reopened the task");
    }
}
