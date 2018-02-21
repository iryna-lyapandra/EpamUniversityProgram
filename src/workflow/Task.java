package workflow;

public class Task {
    private boolean isAssigned;
    private String assignee;
    private State state;

    public Task() {
        this.isAssigned = false;
        this.assignee = "Not assigned";
        this.state = new Opened(this);
    }

    public void open(){
        state.open();
    }
    public void resolve(){
        state.resolve();
    }
    public void close(){
        state.close();
    }
    public void reopen(){
        state.reopen();
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
        this.isAssigned = true;
        System.out.println("Successfully assigned to " + assignee);
    }

    public void removeAssignee(){
        if (isAssigned) {
            System.out.println("Successfully unassigned from " + assignee);
            this.assignee = "Not assigned";
            this.isAssigned = false;
        }
        else {
            System.out.println("This task doesn't have an assignee already");
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
