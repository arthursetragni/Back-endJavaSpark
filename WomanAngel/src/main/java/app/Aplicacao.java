package app;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import model.Denuncia;
import com.google.gson.Gson;

import static spark.Spark.*;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.DenunciaService;
import spark.Route;

public class Aplicacao {
	
	private static DenunciaService denunciaService = new DenunciaService();
	
    public static void main(String[] args) {
        port(6798);

        Configuration configuration = new Configuration(new Version(2, 3, 31));
        
        configuration.setClassForTemplateLoading(Aplicacao.class, "/templates");
        
        staticFiles.location("/templates");	
        
        post("/produto", (request, response) -> denunciaService.add(request, response));
        	

        // Metodo get pra pegar uma denuncia especifica pelo ID
        get("ff/produto/:id", (request, response) -> denunciaService.get(request, response));
        /*get("/produto/update/:id", (request, response) -> tarefaService.update(request, response));

        get("/produto/delete/:id", (request, response) -> tarefaService.remove(request, response));*/

        get("/produto", (request, response) -> denunciaService.getAll(request, response));
               
    }
}