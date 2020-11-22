package ch.aaap.talks.micronaut;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

@Controller
public class RemotingController {

    private static final Logger log = LoggerFactory.getLogger(RemotingController.class);

    private final VaccinationService vaccinationService;

    public RemotingController(VaccinationService vaccinationService) {
        this.vaccinationService = vaccinationService;
    }

    @Post(value = VaccinationService.URI, processes = MediaType.ALL)
    void handleRemotingCallVaccinationService(HttpServletRequest request,
                                              HttpServletResponse response)
            throws IOException, ServletException {
        HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setService(vaccinationService);
        httpInvokerServiceExporter.setServiceInterface(VaccinationService.class);
        httpInvokerServiceExporter.afterPropertiesSet();

        httpInvokerServiceExporter.handleRequest(request, response);
    }
}
