
// Kahn's Topological Sort
class Solution {
    Map<Integer, List<Integer>> courseMap = new HashMap<>();
    int[] indegree;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        
        // create adjacency Map
        for (int[] courseList : prerequisites) {
            int course = courseList[0];
            int prereq = courseList[1];
            
            if (courseMap.get(course) == null) {
                courseMap.put(course, new ArrayList<>());
            }
            
            courseMap.get(course).add(prereq);
            indegree[prereq] = indegree[prereq] + 1;
        }
        
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        
        while (!q.isEmpty()) {
            int c = q.poll();
            
            if (indegree[c] == 0) count += 1;
            if (courseMap.get(c) == null) continue;
            
            // check neighbors
            for (int neighbor : courseMap.get(c)) {
                indegree[neighbor] = indegree[neighbor] - 1;
                
                if (indegree[neighbor] == 0) q.add(neighbor);
            }
            
        }
        
        return count == numCourses;
    }
}