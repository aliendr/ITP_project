package templater;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class PageGenerator {
    private static final String HTML_DIR = "web";

    private static PageGenerator pageGenerator;
    private final Configuration cfg;

    public static PageGenerator instance() {
        if (pageGenerator == null)
            pageGenerator = new PageGenerator();
        return pageGenerator;
    }

    public String getPage(String filename, Map<String, Object> data) throws IOException, TemplateException {
        Writer stream = new StringWriter();
        Template template = cfg.getTemplate(HTML_DIR + File.separator + filename);
        template.process(data, stream);
        return stream.toString();
    }

    private PageGenerator() {
        cfg = new Configuration();
    }
}
