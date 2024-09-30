import java.util.Map;
public class Student {
    private int studentID;
    private String name ;
    private String category;
    private Task assignedTask;
    private Map<String, String> proficiency; // is it the best Idea?!

    public Student(int studentID, String name, String category, Map<String, String> proficiency) {
        this.studentID = studentID;
        this.name = name;
        this.category = category;
        this.proficiency = proficiency;
        this.assignedTask = null;
    }

    public void setAssignTask(Task assignTask){
        this.assignedTask = assignTask;
    }

    public int getStudentID() {
        return studentID;
    }
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }


    public Map<String, String> getProficiency() {
        return proficiency;
    }

    public Task getAssignedTask() {
        return assignedTask;
    }

    public void markTaskCompleted() {
        this.assignedTask = null;
    }


    @Override
    public String toString() {
        return this.name+" "+this.studentID;
    }
}
