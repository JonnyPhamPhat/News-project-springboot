package newsproject.news.api;

import newsproject.news.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String indexPage(Model model){
        model.addAttribute("users", userService.listUserEntity());
        return "index";
    }
}
