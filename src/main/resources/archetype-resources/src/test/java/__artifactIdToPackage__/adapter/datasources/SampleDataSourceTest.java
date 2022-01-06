package ${groupId}.${artifactIdToPackageImport}.adapter.datasources;

import ${groupId}.${artifactIdToPackageImport}.internal.entities.Sample;
import ${groupId}.${artifactIdToPackageImport}.bootstrap.exceptions.NotFoundException;
import org.junit.Assert;
import org.junit.Test;

public class SampleDataSourceTest {

    @Test
    public void shouldReturnFirstExample() {
        SampleDataSource sampleDataSource = new SampleDataSource();
        Sample sample = sampleDataSource.getSample(1);
        Assert.assertEquals("First Example", sample.getDescription());
    }

    @Test
    public void shouldReturnSecondExample() {
        SampleDataSource sampleDataSource = new SampleDataSource();
        Sample sample = sampleDataSource.getSample(2);
        Assert.assertEquals("Second Example", sample.getDescription());
    }

    @Test(expected = NotFoundException.class)
    public void shouldThrowNotFoundExceptionWhenFindNullSample() {
        SampleDataSource sampleDataSource = new SampleDataSource();
        sampleDataSource.getSample(null);
    }

}