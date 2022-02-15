package cn.coding.com.myapplogin.controller;

import cn.coding.com.myapplogin.entity.Developer;
import cn.coding.com.myapplogin.exception.UserNotFoundException;
import cn.coding.com.myapplogin.repository.DeveloperRepository;
import cn.coding.com.myapplogin.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**@Author JosephCrypto
 *@Create 2022-10-2/14/22 10:10 PM
 */
@Controller
public class DeveloperController {

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private DeveloperService developerService;

    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("developer", new Developer());
        return "signup_form";
    }

    @PostMapping( "/process_register")
    public String processRegister(@ModelAttribute Developer developer) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encoderPassword = passwordEncoder.encode(developer.getPassword());
        developer.setEnabled(true);
        developer.setPassword(encoderPassword);

        developerRepository.save(developer);
        return "register_success";
    }

    @GetMapping("/list_developer")
    public String listDevelopers(Model model) {
        List<Developer> listDevelopers = developerRepository.findAll();
        model.addAttribute("listDevelopers", listDevelopers);
        return "list-developer";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes attributes){
        try {
            Developer developer = developerService.getById(id);
            model.addAttribute("developer", developer);
//            model.addAttribute("PageTitle", "Edit Developer (ID : " + id + ")");
            return "signup_form";
        } catch (UserNotFoundException e) {
            attributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/list_developer";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteDeveloper(@PathVariable("id") Long id, RedirectAttributes attributes){
        try {
            developerService.deleteById(id);
            attributes.addFlashAttribute("message", " Developer ID " + id + " has been deleted.");
        } catch (UserNotFoundException e) {
            attributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/list_developer";
    }
}
