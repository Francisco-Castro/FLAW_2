package zipcode.group.walf.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import zipcode.group.walf.WalfApplication;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WalfApplication.class)
public class UserServiceTest {

    @MockBean
    private UserService userService;

    private UserController userController;


    @Before
    public void setUp(){
        this.userController = new UserController(userService);
    }


    @Test
    public void testCreate(){
        //Given
        HttpStatus expected = HttpStatus.CREATED;
        User expectedUser = new User();
        given(userService.create(expectedUser)).willReturn(expectedUser);

        // When
        ResponseEntity<User> response = userController.create(expectedUser);
        HttpStatus actual = response.getStatusCode();
        User actualUser = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedUser, actualUser);
    }

    @Test
    public void testShow() {
        // Given
        Long userid = 1L;
        HttpStatus expected = HttpStatus.OK;
        User expectedUser = new User();
        given(userService.show(1L)).willReturn(expectedUser);

        // When
        ResponseEntity<User> response = userController.show(userid);
        HttpStatus actual = response.getStatusCode();
        User actualUser = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedUser, actualUser);
    }




}
