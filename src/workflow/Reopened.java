package workflow;


public class Reopened implements State {
    private Task task;

    public Reopened (Task task){
        this.task = task;
    }

    public void resolve(){
        task.setState(new Resolved(task));
        System.out.println("Successfully resolved the task");
    }

}
