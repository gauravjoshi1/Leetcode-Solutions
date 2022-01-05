class Solution {
    HashMap<Integer, List<Integer>> courseMap = new HashMap<>();
    HashMap<Integer, Boolean> memo = new HashMap<>(); //optimize DFS pruning
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // construct the hashmap
        for (int[] listOfCourses : prerequisites) {
            int course = listOfCourses[0];
            int prereq = listOfCourses[1];

            if (!courseMap.containsKey(course)) {
                courseMap.put(course, new ArrayList<>());
            }

            courseMap.get(course).add(prereq);

        }

        for (int[] listOfCourses : prerequisites) {
            if (isCyclic(listOfCourses[0], -1)) return false;
        }

        return true;
    }

    private boolean isCyclic(int course, int prereqCourse) {

        // if the path has already been traversed, return previous output
        if (memo.containsKey(course)) return memo.get(course);

        // key does not exist in the map meaning no pre-reqs
        if (!courseMap.containsKey(course)) return false;

        // loop detected
        if (visited.contains(course)) return true;

        visited.add(course);
        // recursively check if any courses that require current course produce cycles
        for (Integer prereq : courseMap.get(course)) {
            boolean hasCycle = isCyclic(prereq, course);
            memo.put(prereq, hasCycle);

            if (hasCycle) return true;
        }

        visited.remove(course);
        return false;
    }
}
