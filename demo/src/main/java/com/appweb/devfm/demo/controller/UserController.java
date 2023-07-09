package com.appweb.devfm.demo.controller;

import com.appweb.devfm.demo.dto.ResponseDto;
import com.appweb.devfm.demo.dto.user.SignInDto;
import com.appweb.devfm.demo.dto.user.SignInResponseDto;
import com.appweb.devfm.demo.dto.user.SignupDto;
import com.appweb.devfm.demo.entity.User;
import com.appweb.devfm.demo.exceptions.AuthenticationFailException;
import com.appweb.devfm.demo.exceptions.CustomException;
import com.appweb.devfm.demo.repository.UserRepository;
import com.appweb.devfm.demo.services.AuthenticationService;
import com.appweb.devfm.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.appweb.devfm.demo.constants.EndPoint.*;

;

@RequestMapping(USER)
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;

    @GetMapping(GET + ALL)
    public List<User> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        return userRepository.findAll();
    }

    @PostMapping("/signup")
    public ResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
        return userService.signUp(signupDto);
    }

    //TODO token should be updated
    @PostMapping("/signIn")
    public SignInResponseDto Signup(@RequestBody SignInDto signInDto) throws CustomException {
        return userService.signIn(signInDto);
    }

//    @PostMapping("/updateUser")
//    public ResponseDto updateUser(@RequestParam("token") String token, @RequestBody UserUpdateDto userUpdateDto) {
//        authenticationService.authenticate(token);
//        return userService.updateUser(token, userUpdateDto);
//    }


//    @PostMapping("/createUser")
//    public ResponseDto updateUser(@RequestParam("token") String token, @RequestBody UserCreateDto userCreateDto)
//            throws CustomException, AuthenticationFailException {
//        authenticationService.authenticate(token);
//        return userService.createUser(token, userCreateDto);
//    }
}