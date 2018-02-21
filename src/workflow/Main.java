package workflow;

public class Main {
    public static void main(String[] args) {
        Task firstTask = new Task();
        firstTask.removeAssignee();
        firstTask.setAssignee("Ivan");
        firstTask.close();
        firstTask.resolve();
        firstTask.reopen();
        firstTask.setAssignee("Denys");
        firstTask.open();
        firstTask.removeAssignee();
    }



}
