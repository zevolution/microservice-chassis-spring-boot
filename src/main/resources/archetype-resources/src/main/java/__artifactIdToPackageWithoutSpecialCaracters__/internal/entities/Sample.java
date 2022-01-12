package ${groupId}.${artifactIdToPackageImport}.internal.entities;

public class Sample {

    private final int id;
    private final String description;

    public Sample(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}