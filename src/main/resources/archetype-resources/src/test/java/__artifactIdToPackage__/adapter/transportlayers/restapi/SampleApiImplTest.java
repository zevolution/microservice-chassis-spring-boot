package ${groupId}.${artifactIdToPackageImport}.adapter.transportlayers.restapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class SampleApiImplTest {

    private final MockMvc mockMvc;

    @Autowired
    public SampleApiImplTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void get_sample_with_id_1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sample/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description", is("First Example")));
    }

    @Test
    void get_sample_with_id_2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sample/{id}", 2)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description", is("Second Example")));
    }

    @Test
    void sample_not_found() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sample/{id}", 3)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code", is(404)));
    }

}