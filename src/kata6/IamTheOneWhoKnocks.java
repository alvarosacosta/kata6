package kata6;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class IamTheOneWhoKnocks {
    private String quote;
    private String author;

    @Override
    public String toString() {
        return this.author + " says: " + this.quote;
    }

}
    
    
