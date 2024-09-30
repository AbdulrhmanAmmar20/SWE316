// The Task class represents an academic task that can be assigned to a student.
public  class Task {
    private int taskID;
    private String taskType;
    private String course;
    private String requesterName;
    private String requesterEmail;
    private String comments;

    private String completionRemark;
    private Student assignedStudent;
    private boolean isCompleted;

    public Task(){

    }
    public Task(int taskId, String taskType, String course , String requesterEmail, String requesterName, String comments) {
        this.taskID = taskId;
        this.taskType = taskType;
        this.course = course;
        this.requesterEmail = requesterEmail;
        this.requesterName = requesterName;
        this.comments = comments;
        this.assignedStudent = null;
        this.isCompleted = false;
    }


    // Getters and setters for the attributes

    public int getTaskID() {
        return taskID;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Student getAssignedStudent() {
        return assignedStudent;
    }

    public String getRequesterEmail() {
        return requesterEmail;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public String getComments() {
        return comments;
    }

    public void setAssignedStudent(Student assignedStudent) {
        this.assignedStudent = assignedStudent;
    }
    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void setCompletionRemark(String completionRemark) {
        this.completionRemark = completionRemark;
    }

    @Override
    public String toString() {
        return taskID+" "+taskType+" "+course+" ";
    }
}
