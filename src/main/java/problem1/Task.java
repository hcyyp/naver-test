package problem1;

public class Task {
    private Long id;
    private String name;
    private int status;

    public Task(Long id, String name, int state) {
        this.id = id;
        this.name = name;
        this.status = state;
    }

    public boolean work() {
        System.out.println("Task id = " + id + "task name = " + name);
        status = 1;
        return true;
    }

    public boolean hasWorked() {
        return status == 1;
    }
}