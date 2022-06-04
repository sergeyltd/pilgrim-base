package org.pilgrim.leetcode.y2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// O(n) cpu time, where n is sum of all consume processes plus sum all processes from task array
// O(n) by memory

public class TaskExecution {

    public boolean canExecute(Task[] tasks) {
        if (tasks == null || tasks.length <= 0) {
            return true;
        }

        final String noConsume = "no consume";
        final String noProcess = "no process";

        Map<String, Set<String>> graph = new HashMap<>();
        // create graph

        for (Task task : tasks) {
            if (task.consumes.length > 0) {
                for (String c : task.consumes) {
                    Set<String> nbr = graph.getOrDefault(c, new HashSet<String>());
                    if (task.procesed.length > 0) {
                        nbr.addAll(Arrays.asList(task.procesed));
                    } else {
                        nbr.add(noProcess);
                    }

                    graph.put(c, nbr);
                }
            } else {
                Set<String> nbr = graph.getOrDefault(noConsume, new HashSet<String>());
                if (task.procesed.length > 0) {
                    nbr.addAll(Arrays.asList(task.procesed));
                } else {
                    nbr.add(noProcess);
                }

                graph.put(noConsume, nbr);
            }
        }

        Set<String> globalVisited = new HashSet<>();
        Set<String> localVisited = new HashSet<>();

        if (isCyclic(graph, noConsume, globalVisited, localVisited)) {
            return false;
        }

        for (String key : graph.keySet()) {
            if (!globalVisited.contains(key)) {
                return false;
            }
        }

        return true;
    }

    private boolean isCyclic(Map<String, Set<String>> graph, String node, Set<String> globalVisited,
            Set<String> localVisited) {

        if (localVisited.contains(node)) {
            return true;
        }

        if (globalVisited.contains(node)) {
            return false;
        }

        globalVisited.add(node);
        localVisited.add(node);

        Set<String> nbrs = graph.getOrDefault(node, new HashSet<String>());
        for (String nb : nbrs) {
            if (isCyclic(graph, nb, globalVisited, localVisited)) {
                return true;
            }
        }

        localVisited.remove(node);

        return false;
    }

    public static void main(String[] args) {
        Task[] tasks = new Task[] { new Task(new String[] {

                }, new String[] { "A1", "A2" }),

                new Task(new String[] { "A2"

                }, new String[] { "A1" }),

                new Task(new String[] { "A1"

                }, new String[] { "A3" }), };

        TaskExecution taskExecution = new TaskExecution();
        boolean res = taskExecution.canExecute(tasks);
        System.out.println(res);
    }

}

class Task {
    String[] consumes;
    String[] procesed;

    public Task(String[] consumes, String[] processed) {
        this.consumes = consumes;
        this.procesed = processed;
    }
}
