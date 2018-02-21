package workflow;

public class Opened implements State {
    private Task task;
    public Opened (Task task){
        this.task = task;
    }
    public void resolve(){
        task.setState(new Resolved(task));
        System.out.println("Successfully resolved the task");
    }

}
