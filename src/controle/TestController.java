package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OeuvreService;
import dao.ProprietaireService;
import meserreurs.*;
import metier.OeuvreVente;
import metier.Proprietaire;

@WebServlet("/TestController")
public class TestController extends BaseController {

    public TestController(){
        super();
        // Ajout de la route
        // param 1 : nom de l'action dans l'url
        // param 2 : nom de la methode (Action à la fin n'est pas obligatoire, c'est juste un style symfony)
        this.get("list","listAction");
        // ... post, delete, put
        // Si vous ajoutez une route avec methode inexistante une erreur sera écrite dans la console et une page 404 sera renvoyé au client

    }


    // Création de la méthode qui va traiter le get Ne pas oublier les throws pour la méthode rendre
    // On récupére tous les éléments nécéssaires comme avant dans l'objet request
    public void listAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            OeuvreService oeuvreService = new OeuvreService();
            request.setAttribute("mesOeuvresVente", oeuvreService.consulterListeOeuvresVente());
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.render("/listerOeuvreVente.jsp",request,response);
    }


}
