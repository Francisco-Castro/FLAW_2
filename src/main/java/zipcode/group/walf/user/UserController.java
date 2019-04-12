package zipcode.group.walf.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @RequestMapping(value="/users", method= RequestMethod.GET)
    public ResponseEntity<Iterable<User>> index() {
        return new ResponseEntity<>(userService.index(), HttpStatus.OK);
    }



    @GetMapping("/users/{userid}")
    public ResponseEntity<User> show(@PathVariable Long userid) {
        return new ResponseEntity<>(userService.show(userid), HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/users/{userid}", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@PathVariable Long userid, @RequestBody User user) {
        return new ResponseEntity<>(userService.update(userid, user), HttpStatus.OK);
    }


    @RequestMapping(value = "/users/{userid}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(Long id) {
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }



}
