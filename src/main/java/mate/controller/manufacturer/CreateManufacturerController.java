package mate.controller.manufacturer;

import mate.lib.Injector;
import mate.model.Manufacturer;
import mate.service.ManufacturerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manufacturer/create")
public class CreateManufacturerController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("mate");
    private final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/manufacturers/create.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(req.getParameter("name"));
        manufacturer.setCountry(req.getParameter("country"));
        manufacturerService.create(manufacturer);
        resp.sendRedirect(req.getContextPath() + "/index");
    }
}
