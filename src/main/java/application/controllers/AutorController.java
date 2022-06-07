package application.controllers;
 
/*pacotes para o funcionamento do project*/

import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
import application.models.Autor;
import application.repositories.AutorRepository;

/* criação da rota /autor */
@Controller
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    private AutorRepository autorRepo;
    
    /* criação da rota /list que está dentro de /autor */
    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("autores", autorRepo.findAll());
        return "list.jsp"; 
    }
    
    /* criação da rota /insert que está dentro de /autor */
    @RequestMapping("/insert")
    public String formInsert() {
        return "insert.jsp";
    }

    /* inserir dados na table autor */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String saveInsert(@RequestParam("nome") String nome) {
        Autor autor = new Autor();
        autor.setNome(nome);
 
        autorRepo.save(autor);
 
        return "redirect:/autor/list";
    }

    /* criação da rota /update que está dentro da rota /autor */
 
    @RequestMapping("/update/{id}")
    public String formUpdate(Model model, @PathVariable int id) {
        Optional<Autor> autor = autorRepo.findById(id);
        if(!autor.isPresent())
            return "redirect:/autor/list";
        model.addAttribute("autor", autor.get());
        return "/autor/update.jsp";
    }
    
    /* mudando dados na table autor */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String saveUpdate(@RequestParam("nome") String nome, @RequestParam("id") int id) {
        Optional<Autor> autor = autorRepo.findById(id);
        if(!autor.isPresent())
            return "redirect:/autor/list";
        autor.get().setNome(nome);
 
        autorRepo.save(autor.get());
 
        return "redirect:/autor/list";
    }

    /* criação da rota /delete que está dentro da rota /autor */
    @RequestMapping("/delete/{id}")
    public String formDelete(Model model, @PathVariable int id) {
        Optional<Autor> autor = autorRepo.findById(id);
        if(!autor.isPresent())
            return "redirect:/autor/list";
        model.addAttribute("autor", autor.get());
        return "/autor/delete.jsp";
    }
    
    /* deletando dados da tabela autor */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String confirmDelete(@RequestParam("id") int id) {
        autorRepo.deleteById(id);
        return "redirect:/autor/list";
    }
}

/* */