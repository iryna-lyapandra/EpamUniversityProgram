package workflow;

public interface State {
    default void open(){
        System.out.println("Opening the task is not allowed");
    }
    default void resolve(){
        System.out.println("Resolving the task is not allowed");
    }
    default void reopen(){
        System.out.println("Reopening the task is not allowed");
    }
    default void close(){
        System.out.println("Closing the task is not allowed");
    }
}
