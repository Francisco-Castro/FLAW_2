package zipcode.group.walf.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Entity;
import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Value("classpath:user.json")
    Resource resource;
    PathMatchingResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();

    private JacksonTester<User> json;

    @Test
    public void testClassSignatureAnnotations() {
        Assert.assertTrue(User.class.isAnnotationPresent(Entity.class));
    }


    @Test
    public void testCreateJson() throws IOException {
        ObjectMapper jsonWriter = new ObjectMapper();
        JacksonTester.initFields(this, jsonWriter);
        User user = new User();
        user.setUsername("laxmi");
        user.setUserid(1l);
//
//        String json = jsonWriter.writeValueAsString(user);
//        System.out.println(json);

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("user.json").getFile());
        System.out.println(file.getAbsolutePath());


       assertThat(this.json.write(user)).isEqualToJson(file);


    }


}
