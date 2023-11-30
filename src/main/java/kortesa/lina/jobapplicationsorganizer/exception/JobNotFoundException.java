package kortesa.lina.jobapplicationsorganizer.exception;

public class JobNotFoundException extends RuntimeException{

    public JobNotFoundException(Long id) {
        super("The job with id: '" + id + "' does not exist in our records");

    }
}
