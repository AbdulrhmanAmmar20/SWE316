public class GradingTask extends Task {

    @Override
    public boolean isCompleted( ) {
        System.out.println("Grading task completed. Average grade calculated.");
        return false;

    }
}
