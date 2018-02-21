package workflow;

public class Closed implements State{
    private Task task;

    public Closed (Task task){
        this.task = task;
    }

    public void reopen(){
        task.setState(new Reopened(task));
        System.out.println("Successfully reopened the task");
    }
}
