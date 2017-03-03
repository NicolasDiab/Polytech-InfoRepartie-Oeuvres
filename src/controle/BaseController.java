package controle;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gorya on 3/3/17.
 */
public abstract class BaseController extends HttpServlet {

    private Map<METHOD, Map<String, String>> routes;
    private static final String ACTION_TYPE = "action";
    private static final String ERROR_KEY = "messageErreur";
    private static final String ERROR_PAGE = "/erreur.jsp";

    public BaseController() {
        super();
        this.routes = new HashMap<>();
        for (METHOD method : METHOD.values()) {
            this.routes.put(method, new HashMap<>());
        }

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        requestHandle(METHOD.GET, req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        requestHandle(METHOD.POST, req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        requestHandle(METHOD.DELETE, req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        requestHandle(METHOD.PUT, req, resp);
    }

    private void requestHandle(METHOD method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String actionName = req.getParameter(ACTION_TYPE);
        Object[] objects = new Object[]{req, resp};
        if (this.routes.get(METHOD.GET).containsKey(actionName)) {
            try {
                this.call(objects, this.routes.get(METHOD.GET).get(actionName));
            } catch (Exception e) {
                System.out.println("ERROR - REQUEST HANDLE - " + method + " : " + actionName + " method unknown");
                this.notFound(req,resp);
            }
        } else this.notFound(req,resp);
    }

    protected void render(String name, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(name);
        dispatcher.forward(req, resp);
    }

    private void notFound(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        this.render(this.ERROR_PAGE,req,resp);
    }

    private Object call(Object[] args, String method) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class[] paramTypes = new Class[]{HttpServletRequest.class,HttpServletResponse.class};
        Method m = this.getClass().getMethod(method, paramTypes);
        return m.invoke(this, args);
    }


    protected BaseController get(String url, String method) {
        this.routes.get(METHOD.GET).put(url, method);
        return this;
    }

    protected BaseController post(String url, String method) {
        this.routes.get(METHOD.POST).put(url, method);
        return this;
    }

    protected BaseController put(String url, String method) {
        this.routes.get(METHOD.PUT).put(url, method);
        return this;
    }

    protected BaseController delete(String url, String method) {
        this.routes.get(METHOD.DELETE).put(url, method);
        return this;
    }


}

enum METHOD {
    POST, PUT, DELETE, GET
}
