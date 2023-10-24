package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import dao.DenunciaDAO;
import model.Denuncia;
import spark.Request;
import spark.Response;


public class DenunciaService{

	private DenunciaDAO denunciaDAO;

	private String processarDenuncias(List<Denuncia> denuncias) {
		// Construa um JSON contendo as denúncias
		StringBuilder jsonDenuncias = new StringBuilder("[");
		for (Denuncia denuncia : denuncias) {
			jsonDenuncias.append("{");
			jsonDenuncias.append("\"categoria\":\"").append(denuncia.getCategoria()).append("\",");
			jsonDenuncias.append("\"localizacao\":\"").append(denuncia.getLocalizacao()).append("\",");
			jsonDenuncias.append("\"descricao\":\"").append(denuncia.getDescricao()).append("\"");
			jsonDenuncias.append("},");
		}
		// Remova a vírgula extra se houver denúncias
		if (denuncias.size() > 0) {
			jsonDenuncias.deleteCharAt(jsonDenuncias.length() - 1);
		}
		jsonDenuncias.append("]");
	
		// Retorna o JSON gerado como uma string
		return jsonDenuncias.toString();
	}


	public DenunciaService() {
		denunciaDAO = new DenunciaDAO();

	}

	public Object add(Request request, Response response) {
		denunciaDAO.conectar();
		int id = Integer.parseInt(request.queryParams("id"));
		String localizacao = request.queryParams("localizacao");
		String descricao = request.queryParams("descricao");
		String categoria = request.queryParams("categoria");
		String data = request.queryParams("data");
		int idUsuario = Integer.parseInt(request.queryParams("idUsuario"));
		
		Denuncia denuncia = new Denuncia(id, localizacao, descricao, categoria, data, idUsuario);
		denunciaDAO.inserirDenuncia(denuncia);

		response.status(201); // 201 Created
		response.redirect("./index.html");
                	
		denunciaDAO.close();
		return id;
	}
	
    public Object get(Request request, Response response) {
        denunciaDAO.conectar();
        int id = Integer.parseInt(request.params(":id"));		
		Denuncia denuncia =  denunciaDAO.get(id);
        
        return denuncia;
    }
    
    public String getAll(Request request, Response response) {
		denunciaDAO.conectar();
		List<Denuncia> denuncias = denunciaDAO.getAll();
		
		// Faz o processamento necessário para gerar o JSON
		String json = processarDenuncias(denuncias);
		response.header("Access-Control-Allow-Origin", "*");
	
		// Configura o tipo de conteúdo da resposta como JSON
		response.type("application/json");

		
		// Configura o corpo da resposta com o JSON gerado
		response.body(json);
		

	
		return json;
	}
	
}