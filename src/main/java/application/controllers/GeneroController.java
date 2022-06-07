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
 
import application.models.Genero;
import application.repositories.GeneroRepository;

/* criação da rota /genero */
@Controller
@RequestMapping("/genero")
public class GeneroController {
    @Autowired
    private GeneroRepository generoRepo;

    /* criação da rota /list que está dentro de /genero */    
    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("generos", generoRepo.findAll());
        return "list.jsp"; 
    }

    /* criação da rota /insert que está dentro de /genero */    
    @RequestMapping("/insert")
    public String formInsert() {
        return "insert.jsp";
    }

    /* inserir dados na table genero */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String saveInsert(@RequestParam("nome") String nome) {
        Genero genero = new Genero();
        genero.setNome(nome);
 
        generoRepo.save(genero);
 
        return "redirect:/genero/list";
    }

    /* criação da rota /update que está dentro de /genero */ 
    @RequestMapping("/update/{id}")
    public String formUpdate(Model model, @PathVariable int id) {
        Optional<Genero> genero = generoRepo.findById(id);
        if(!genero.isPresent())
            return "redirect:/genero/list";
        model.addAttribute("genero", genero.get());
        return "/genero/update.jsp";
    }

    /* inserir dados na table genero */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String saveUpdate(@RequestParam("nome") String nome, @RequestParam("id") int id) {
        Optional<Genero> genero = generoRepo.findById(id);
        if(!genero.isPresent())
            return "redirect:/genero/list";
        genero.get().setNome(nome);
 
        generoRepo.save(genero.get());
 
        return "redirect:/genero/list";
    }

    /* criação da rota /delete que está dentro de /genero */ 
    @RequestMapping("/delete/{id}")
    public String formDelete(Model model, @PathVariable int id) {
        Optional<Genero> genero = generoRepo.findById(id);
        if(!genero.isPresent())
            return "redirect:/genero/list";
        model.addAttribute("genero", genero.get());
        return "/genero/delete.jsp";
    }

    /* deletando dados na table genero */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String confirmDelete(@RequestParam("id") int id) {
        generoRepo.deleteById(id);
        return "redirect:/genero/list";
    }
}