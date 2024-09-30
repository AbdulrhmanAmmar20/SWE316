import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TaskManager {
    private static List<Student> students;
    private List<Task> tasks;

    public TaskManager(List<Student> students, List<Task> tasks) {
        this.tasks = tasks;
        this.students = students;
    }




    public Map<Task, Student> assignTasksToStudents() {
        List<String> requiredLevels = List.of("Advanced", "Expert");
        Map<Task, Student> taskAssignmentMap = new HashMap<>();  // Map to store task-student assignments

        // Loop over each task in the list
        for (Task task : tasks) {
            String courseName = task.getCourse();

            // Loop over each student to find an eligible student for the task
            for (Student student : students) {
                Map<String, String> proficiencyMap = student.getProficiency();
                String proficiencyLevel = proficiencyMap.get(courseName);

                // Check if the student has the required proficiency and is not already assigned a task
                if (requiredLevels.contains(proficiencyLevel) && student.getAssignedTask() == null && task.getAssignedStudent() == null) {
                    task.setAssignedStudent(student);  // Assign the student to the task
                    student.setAssignTask(task);       // Mark the task as assigned to the student
                    taskAssignmentMap.put(task, student);  // Store the assignment in the map
                    break;  // Break the inner loop once the task is assigned
                }
            }
        }

        return taskAssignmentMap;

    }



    public Task findTaskByStudentID(Map<Task, Student> taskAssignmentMap, int studentID) {
        for (Map.Entry<Task, Student> entry : taskAssignmentMap.entrySet()) {
            Student student = entry.getValue();  // Get the student for the current task
            if (student.getStudentID() == studentID) {  // Compare student IDs as integers
                return entry.getKey();  // Return the associated task
            }
        }
        return null;  // Return null if no task is found for the given student ID
    }






    public void saveAssignedTasks(String directory) {
        String outputFilePath = Paths.get(directory, "sheet4_assignedTasks.csv").toString(); // Define the output file path

        // Prepare CSV data with headers
        StringBuilder csvData = new StringBuilder("Task ID,Requester Email,Requester Name,Type of Task,Course,Any Comments / Suggestions,Student ID,Student Name\n");

        // Populate the CSV data with task assignment information
        for (Task task : tasks) {
            csvData.append(task.getTaskID()).append(",")
                    .append(task.getRequesterEmail()).append(",") // Requester Email
                    .append(task.getRequesterName()).append(",") // Requester Name
                    .append(task.getTaskType()).append(",") // Type of Task
                    .append(task.getCourse()).append(",") // Course
                    .append(task.getComments()).append(","); // Any Comments / Suggestions

            // Check if the task has been assigned and append the student details
            if (task.getAssignedStudent() != null) {
                Student assignedStudent = task.getAssignedStudent();
                csvData.append(assignedStudent.getStudentID()).append(",")
                        .append(assignedStudent.getName()).append("\n");
            } else {
                csvData.append("Unassigned,Unassigned\n");
            }
        }

        // Write the CSV data to the file
        try (FileWriter writer = new FileWriter(outputFilePath)) {
            writer.write(csvData.toString());
            System.out.println("Assigned tasks saved successfully to " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error saving assigned tasks: " + e.getMessage());
        }
    }



    // Getters for students and tasks lists
    public List<Student> getStudents() {
        return students;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}

