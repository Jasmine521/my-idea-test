import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import java.util.List;


public class Book {
    public long id;
    public String name;
    public String author;

    @JacksonXmlProperty(localName = "isbn")
    public Attrisbn attrisbn;
    public List<String> tags;
    public String pubDate;

    public static class Attrisbn {
        @JacksonXmlProperty(isAttribute = true, localName = "lang")
        public String lang;
        @JacksonXmlText
        public String isbn;
    }
}

