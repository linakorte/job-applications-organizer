package kortesa.lina.jobapplicationsorganizer.exception;

public class CompanyNotFoundException extends RuntimeException{

    public CompanyNotFoundException(Long id) {
        super("The company with id: '" + id + "' does not exist in our records");

    }
}
