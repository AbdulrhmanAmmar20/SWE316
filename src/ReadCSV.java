import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadCSV {
    public static List<Student> readStudents(String filePath) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Read the header line
            String[] headers = line.split(",");
            List<String> subjects = new ArrayList<>();
            // Extract subject names dynamically based on the CSV headers
            for (int i = 5; i < headers.length - 1; i++) { // Assuming subjects start at column 5
                subjects.add(headers[i]);
            }
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int studentID = Integer.parseInt(values[1]);
                String name = values[2];
                String category = values[4];
                Map<String, String> proficiency = new HashMap<>();

                // Map proficiencies to subjects
                for (int i = 0; i < subjects.size(); i++) {
                    proficiency.put(subjects.get(i), values[5 + i]);
                }

                students.add(new Student(studentID, name, category, proficiency));
            }
            System.out.println("Students loaded successfully.");
        } catch (IOException e) {
            System.err.println("Error reading students file: " + e.getMessage());
        }
        return students;
    }
     public static List<Task> readTasks(String filePath) {
            List<Task> tasks = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line = br.readLine(); // Skip the header line
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");

                    int taskID = Integer.parseInt(values[0]);
                    String requesterEmail = values[1];
                    String requesterName = values[2];
                    String taskType = values[3];
                    String course = values[4];
                    String comments = values[5];
                    // Creating a Task object with the parsed values
                    Task task = new Task(taskID,taskType, course, requesterEmail,requesterName,comments);
                    tasks.add(task);
                }
                System.out.println("Tasks loaded successfully.");
            } catch (IOException e) {
                System.err.println("Error reading tasks file: " + e.getMessage());
            }
            return tasks;
        }

    public static List<TaskAssignment> readTaskAssignments(String csvFile) {
        List<TaskAssignment> taskAssignments = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            br.readLine();  // Skip the header line

            // Read each line
            while ((line = br.readLine()) != null) {
                // Split the line by comma (CSV format)
                String[] fields = line.split(",");
                // Parse fields to create TaskAssignment objects
                int taskID = Integer.parseInt(fields[0]);
                String requesterEmail = fields[1];
                String requesterName = fields[2];
                String typeOfTask = fields[3];
                String course = fields[4];
                String comments = fields[5];
                int studentID = Integer.parseInt(fields[6]);
                String studentName = fields[7];

                // Create a new TaskAssignment object and add it to the list
                TaskAssignment taskAssignment = new TaskAssignment(taskID, requesterEmail, requesterName, typeOfTask, course,
                        comments, studentID, studentName);
                taskAssignments.add(taskAssignment);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return taskAssignments;
    }




}
