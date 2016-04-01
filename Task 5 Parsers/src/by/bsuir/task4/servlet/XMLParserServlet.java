package by.bsuir.task4.servlet;

import by.bsuir.task4.exception.XMLParserException;
import by.bsuir.task4.factory.DeviceBuilderFactory;
import by.bsuir.task4.parser.AbstractDevicesBuilder;
import by.bsuir.task4.validator.XMLValidator;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ParserServlet")
public class XMLParserServlet extends HttpServlet {
    public static final String FILE_PATH = "resources/devices.xml";
    public static final String SCHEMA_PATH = "resources/devices.xsd";
    public static final String RESULT_PATH = "views/result.jsp";
    public static final String VALIDATION_ERROR_MESSAGE = "XML file is not valid";
    public static final String PARSING_ERROR_MESSAGE = "Parsing failed ";
    public static final Logger LOG = Logger.getLogger(XMLParserServlet.class);
    private String xmlPath;

    @Override
    public void init() throws ServletException {
        super.init();
        xmlPath = getServletContext().getRealPath("/");
        BasicConfigurator.configure();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parser = request.getParameter("parser");
        if (XMLValidator.validate(xmlPath + FILE_PATH, xmlPath + SCHEMA_PATH)) {
            try {
                DeviceBuilderFactory factory = new DeviceBuilderFactory();
                AbstractDevicesBuilder builder = factory.createDevicesBuilder(parser);
                builder.buildSetDevices(xmlPath + FILE_PATH);
                request.setAttribute("parser", parser);
                request.setAttribute("peripherals", builder.getPeripherals());
                request.setAttribute("components", builder.getComponents());
                request.getRequestDispatcher(RESULT_PATH)
                        .forward(request, response);
            } catch (XMLParserException e) {
                LOG.error(PARSING_ERROR_MESSAGE + e);
                request.setAttribute("errorMessage", PARSING_ERROR_MESSAGE);
                request.getRequestDispatcher("index.jsp")
                        .forward(request, response);
            }
        } else {
            LOG.error(VALIDATION_ERROR_MESSAGE);
            request.setAttribute("errorMessage", VALIDATION_ERROR_MESSAGE);
            request.getRequestDispatcher("index.jsp")
                    .forward(request, response);
        }
    }
}
