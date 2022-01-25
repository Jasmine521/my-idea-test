package xml;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = Main.class.getResourceAsStream("/book.xml");
        JacksonXmlModule module = new JacksonXmlModule();
        XmlMapper mapper = new XmlMapper(module);
        Book book = mapper.readValue(inputStream, Book.class);
        System.out.println(book.id);
        System.out.println(book.name);
        System.out.println(book.author);
        System.out.println(book.attrisbn.lang);
        System.out.println(book.attrisbn.isbn);
        System.out.println(book.tags);
        System.out.println(book.pubDate);

    }
}
