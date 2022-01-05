class Solution {
    HashMap<Integer, List<Integer>> courseMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // construct the hashmap
        for (int[] listOfCourses : prerequisites) {
            int course = listOfCourses[0];
            int prereq = listOfCourses[1];

            if (!courseMap.containsKey(course)) {
                List<Integer> prereqList = new ArrayList<>();
                prereqList.add(prereq);
                courseMap.put(course, prereqList);
            } else {
                List<Integer> prereqList = courseMap.get(course);
                prereqList.add(prereq);
                courseMap.put(course, prereqList);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(i)) return false;
        }

        return true;
    }

    private boolean isCyclic(int course) {
        // key does not exist in the map meaning no pre-reqs
        if (courseMap.get(course) == null) return false;

        // loop detected
        if (visited.contains(course)) return true;

        visited.add(course);

        // recursively check if any courses that require current course produce cycles
        for (Integer prereq : courseMap.get(course)) {
            if (isCyclic(prereq)) return true;
        }

        visited.remove(course);
        return false;
    }
}
