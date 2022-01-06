package ${groupId}.${artifactIdToPackageImport}.bootstrap.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

}
