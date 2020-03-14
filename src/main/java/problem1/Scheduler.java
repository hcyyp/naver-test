package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Scheduler {

    public void schedule(TaskDAG taskDAG) {
        while (true) {
            List<Task> todo = new ArrayList<>();
            for (Task task : taskDAG.getTasks()) {
                if (!task.hasWorked()) {
                    Set<Task> prevs = taskDAG.getMap().get(task);
                    if (prevs != null && !prevs.isEmpty()) {
                        boolean toAdd = true;

                        if (toAdd) {
                            todo.add(task);
                        }
                    } else {
                        todo.add(task);
                    }
                }
            }
            if (!todo.isEmpty()) {
                for (Task task : todo) {
                    if (!task.hasWorked()) {




                        throw new RuntimeException();
                    }
                }
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        //Test input: Task A, Task B, Task C, Task D, Task E, Task F, Task G, Task H
        //
        //Test output: Task H, Task B, Task G, Task C, Task E, Task A, Task D, Task F

        TaskDAG taskDAG = new TaskDAG();
        Task taskA = new Task(1L, "A", 0);
        Task taskB = new Task(2L, "B", 0);
        Task taskC = new Task(3L, "C", 0);
        Task taskD = new Task(4L, "D", 0);
        Task taskE = new Task(5L, "E", 0);
        Task taskF = new Task(6L, "F", 0);
        Task taskG = new Task(7L, "G", 0);
        Task taskH = new Task(8L, "H", 0);


        taskDAG.addTask(taskA);
        taskDAG.addTask(taskB);
        taskDAG.addTask(taskC);
        taskDAG.addTask(taskD);
        taskDAG.addTask(taskE);
        taskDAG.addTask(taskF);
        taskDAG.addTask(taskG);
        taskDAG.addTask(taskH);

        taskDAG.addEdge(taskH, taskC);
        taskDAG.addEdge(taskC, taskA);
        taskDAG.addEdge(taskB, taskG);
        taskDAG.addEdge(taskB, taskE);
        taskDAG.addEdge(taskG, taskE);
        taskDAG.addEdge(taskG, taskA);
        taskDAG.addEdge(taskA, taskD);
        taskDAG.addEdge(taskE, taskF);
        taskDAG.addEdge(taskD, taskF);

        Scheduler scheduler = new Scheduler();
        scheduler.schedule(taskDAG);

    }


}
