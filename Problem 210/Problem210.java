import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
 * prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any
 * of them. If it is impossible to finish all courses, return an empty array.
 *
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the
 * correct course order is [0,1].
 *
 * Example 2:
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and
 * 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 *
 * Example 3:
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 *
 * Constraints:
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 */
public class Problem210 {

    /**
     * Inner Course class to help with BFS traversal
     */
    private static class Course {
        int id;
        int numAncestors = 0;
        List<Course> children = new ArrayList<>();

        Course(int id) {
            this.id = id;
        }

        void addChild(Course child) {
            child.numAncestors += 1;
            this.children.add(child);
        }
    }

    /**
     * BFS approach
     * Representing pre-requisites as children, and traversing them in order of numAncestors
     *
     * Time Complexity: O(E + V)
     * Space Complexity: O(N)
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    private static int[] findOrder(int numCourses, int[][] prerequisites) {
        Course[] courses = new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Course(i);
        }

        for (int[] req : prerequisites) {
            courses[req[1]].addChild(courses[req[0]]);
        }

        int courseCount = 0;
        List<Course> order = new ArrayList<>();

        Queue<Course> queue = new ArrayDeque<>();
        for (Course course : courses) {
            if (course.numAncestors == 0) {
                queue.add(course);
                courseCount++;
                order.add(course);
            }
        }

        while (courseCount < numCourses && !queue.isEmpty()) {
            Course course = queue.poll();
            for (Course child : course.children) {
                child.numAncestors -= 1;
                if (child.numAncestors == 0) {
                    queue.add(child);
                    courseCount++;
                    order.add(child);
                }
            }
        }

        if (courseCount < numCourses) { return new int[0]; }
        return order.stream().mapToInt(course -> course.id).toArray();
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

        int[] order = findOrder(numCourses, prerequisites);
        Arrays.stream(order).forEach(System.out::println);
    }
}
