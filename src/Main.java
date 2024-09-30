import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Student> students= ReadCSV.readStudents("sheet2_studentsSurveyResults(1).csv");
        List<Task> tasks = ReadCSV.readTasks("sheet3_taskOpenings(1).csv");
        List<TaskAssignment> taskAssignments = ReadCSV.readTaskAssignments("sheet4_assignedTasks(1).csv");

        TaskManager taskManager = new TaskManager(students, tasks);
        Map<Task, Student> map = taskManager.assignTasksToStudents();

        System.out.println("Welcome to the Task Management System");
        System.out.println("Please select an option:");
        System.out.println("1. Run the automated task matching");
        System.out.println("2. Mark a task as completed");
        System.out.print("Enter option number: ");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left by nextInt()

        if (option == 1) {
            System.out.println(tasks);
            taskManager.assignTasksToStudents();
            taskManager.saveAssignedTasks("C:\\Users\\hp\\Desktop\\SWE316 HW");

        } else {
            System.out.print("Enter the student ID: ");
            String studentIDInput = scanner.nextLine();

            int studentID = Integer.parseInt(studentIDInput);  // Parse the input to int
            Task task = taskManager.findTaskByStudentID(map,studentID);  // Pass the parsed int
            if (task != null) {
                System.out.println("Task assigned to you:");
                System.out.println(task);
                System.out.println("To mark the task as completed,type in “complete” to proceed or “quit” to quit ");
                String st = scanner.nextLine().toLowerCase();
                if(st.equals("complete")){
                    Student student = map.get(task);
                    student.markTaskCompleted();

                }
                else {
                    System.exit(0); // Exit the program after marking the task
                }





            }
            else {
                System.out.println("No task found for this student ID.");
            }


        }

        System.exit(0); // Exit the program after marking the task
 }
    }

