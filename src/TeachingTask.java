public class TeachingTask extends Task {

    @Override
    public boolean isCompleted() {
        // Custom logic for completing a teaching task
        System.out.println("Teaching task completed. Total number of students attended recorded.");
        return false;

    }
}
