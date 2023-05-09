package newsproject.news.api;

import newsproject.news.Service.IUserService;
import newsproject.news.dto.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
@CrossOrigin
public class UserRegisterController {
    @Autowired
    private IUserService userService;

    @ModelAttribute("user")
    public UserRegisterDTO userRegisterDTO(){
        return new UserRegisterDTO();
    }

    @GetMapping
    public String showRegister(){
        return "/register";
    }

    @PostMapping
    public String registrationUser(@ModelAttribute("user") UserRegisterDTO userRegisterDTO){
        userService.createUser(userRegisterDTO);
        return "redirect:/register?exit";
    }
}
