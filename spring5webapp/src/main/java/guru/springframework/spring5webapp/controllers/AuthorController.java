package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepsitory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepsitory authorRepsitory;

    public AuthorController(AuthorRepsitory authorRepsitory) {
        this.authorRepsitory = authorRepsitory;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorRepsitory.findAll());

        return "authors/list";

    }
}
