public class TaskAssignment {
    private int taskID;
    private String requesterEmail;
    private String requesterName;
    private String typeOfTask;
    private String course;
    private String comments;
    private int studentID;
    private String studentName;

    // Constructor
    public TaskAssignment(int taskID, String requesterEmail, String requesterName, String typeOfTask, String course,
                          String comments, int studentID, String studentName) {
        this.taskID = taskID;
        this.requesterEmail = requesterEmail;
        this.requesterName = requesterName;
        this.typeOfTask = typeOfTask;
        this.course = course;
        this.comments = comments;
        this.studentID = studentID;
        this.studentName = studentName;
    }


    @Override
    public String toString() {
        return "TaskAssignment{" +
                "taskID=" + taskID +
                ", requesterEmail='" + requesterEmail + '\'' +
                ", requesterName='" + requesterName + '\'' +
                ", typeOfTask='" + typeOfTask + '\'' +
                ", course='" + course + '\'' +
                ", comments='" + comments + '\'' +
                ", studentID=" + studentID +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
