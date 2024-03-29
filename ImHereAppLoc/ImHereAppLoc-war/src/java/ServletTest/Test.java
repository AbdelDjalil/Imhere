/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletTest;

import imhereEntity.Utilisateur;
import imhereSession.UtilisateurFacade;
import imhereSession.UtilisateurFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Djalil
 */
public class Test extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // ajouter avec Olivier
    @EJB //injecter l'ejb section 
    private UtilisateurFacadeLocal testfacade = new UtilisateurFacade ();
    // ajouter avec Olivier
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // ajouter avec Olivier
        //testfacade.Auth(3, "loova", "here");
        List <Utilisateur> testuser = testfacade.findAll();
        // ajouter avec Olivier
        
        try {
            //* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Test at " + request.getContextPath () + "</h1>");
            for(Utilisateur u : testuser){
                if(u.getNom()==null){
                    testfacade.effacer(u);
                }
                else {
                out.println("<ul>");
                out.println("<li>"+ u.getNom() + " " + u.getMotdepasse() + " " + u.getLatitude() + " " + u.getId() + "</li>");
                out.println("<ul>");
                out.println("</ul>");
                }
            }
            out.println("</body>");
            out.println("</html>");
             //*/
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
