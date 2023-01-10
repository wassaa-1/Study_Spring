package dev.bank.bankstatement.web.controller;

import dev.bank.bankstatement.core.user.application.UserEditor;
import dev.bank.bankstatement.core.user.application.UserFinder;
import dev.bank.bankstatement.core.user.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController // @Controller + @ResponseBody
@RequestMapping(path = "/api/users")
public class UserRestController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final UserFinder finder;
    private final UserEditor editor;

    public UserRestController(UserFinder finder, UserEditor editor) {
        this.finder = finder;
        this.editor = editor;
    }

    /**
     * 모든 User list를 반환한다.
     * @return List<User>
     */
//    @RequestMapping(path = "/api/users", method = RequestMethod.GET)
//    @ResponseBody
    @GetMapping
    public List<User> findAll() {
        // 출력문 shortcut: sout
//        System.out.println("findAll() called");

        logger.info("-- GET: localhost:8080/api/users, findAll() called.");

        return finder.findAll();
    }

    @GetMapping("/{id}") // localhost:8080/api/user/qqqwww
    public User findUser(@PathVariable String id) { // @PathVariable
        logger.info("-- Get: localhost:8080/api/users/{}, findUser() called", id);
        logger.debug("-- @PathVariable String id: {}", id);

        return finder.findUser(id);
    }

    @PostMapping
    public String createUser(@RequestBody @Validated User.Request newUser, BindingResult br) {
        logger.info("-- POST: localhost:8080/api/users, createUser() called");
        logger.info("-- @RequestBody User: {}", newUser);

        // ** BindingResult 파라미터는 @Validated annotation이 부여된 파라미터 바로 뒤에 작성해야함
        if (br.hasErrors()) {
            return "뭐하세요?";
        }

//        return editor.create(newUser);
        return null;
    }


    @PutMapping
    public User updateUser(@RequestBody User updateUser) {
        logger.info("-- PUT: localhost:8080/api/users, updateUser() called");
        logger.info("-- @RequestBody User: {}", updateUser);

        return editor.update(updateUser);
    }

    @DeleteMapping
    public String deleteUser(@RequestParam("id") String id) {
        // @RequestParam("쿼리스트링에서 사용할 변수명") String id(Java에서 쿼리스트링을 통해 받았을 때 사용할 지역 변수 이름
        logger.info("-- DELETE: localhost:8080/api/users, deleteUser() called");
        logger.info("-- @RequestParam id: {}", id);

        return editor.delete(id);
    }
}
