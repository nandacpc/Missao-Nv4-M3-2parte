package cadastroee.servlets;

import cadastroee.controller.ProdutoFacadeLocal;
import cadastroee.model.Produtos;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletProdutoFC", urlPatterns = {"/ServletProdutoFC"})
public class ServletProdutoFC extends HttpServlet {

    @EJB
    private ProdutoFacadeLocal facade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String destino = "";

        if (acao != null) {
            switch (acao) {
                case "listar":
                    List<Produtos> produtos = facade.findAll();
                    request.setAttribute("produtos", produtos);
                    destino = "ProdutoLista.jsp";
                    break;
                case "formIncluir":
                case "formAlterar":
                    destino = "ProdutoDados.jsp";
                    break;
                case "excluir":
                    int idExcluir = Integer.parseInt(request.getParameter("id"));
                    Produtos produtoExcluir = facade.find(idExcluir);
                    if (produtoExcluir != null) {
                        facade.remove(produtoExcluir);
                    }
                    List<Produtos> produtosExcluidos = facade.findAll();
                    request.setAttribute("produtos", produtosExcluidos);
                    destino = "ProdutoLista.jsp";
                    break;
                case "alterar":
                    int idAlterar = Integer.parseInt(request.getParameter("id"));
                    Produtos produtoAlterar = facade.find(idAlterar);
                    if (produtoAlterar != null) {                        
                    }
                    List<Produtos> produtosAlterados = facade.findAll();
                    request.setAttribute("produtos", produtosAlterados);
                    destino = "ProdutoLista.jsp";
                    break;
                case "incluir":
                    Produtos novoProduto = new Produtos();                    
                    facade.create(novoProduto);
                    List<Produtos> produtosIncluidos = facade.findAll();
                    request.setAttribute("produtos", produtosIncluidos);
                    destino = "ProdutoLista.jsp";
                    break;
                default:                    
                    destino = "Erro.jsp";
            }
        } else {            
            destino = "Erro.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Front Controller de Produtos";
    }
}


