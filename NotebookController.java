import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/notebooks")
public class NotebookController {

    @Autowired
    private ScrapingService scrapingService;

    @GetMapping
    public List<Notebook> getNotebooks() throws IOException {
        return scrapingService.scrapeNotebooks();
    }
}
