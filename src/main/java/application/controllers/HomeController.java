package application.controllers;

/*pacotes para o funcionamento do project*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

/* criação da rota home e do método index que redireciona até o index.jsp */

@Controller
public class HomeController{
@RequestMapping(method = RequestMethod.GET)
public String index(){
    return "home/index.jsp";
}
}