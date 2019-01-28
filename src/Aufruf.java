import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Aufruf {
    public static void main(String[] args) throws Exception
    {

        ObjectMapper objectMapper=new ObjectMapper();
        Merge a = objectMapper.readValue(new File("src/merge.json"), Merge.class);
        //marskall
        JAXBContext jaxbContext     = JAXBContext.newInstance( Merge.class );
        Marshaller jaxbMarshaller   = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        OutputStream os = new FileOutputStream( "merge.xml" );
        jaxbMarshaller.marshal( a, os );
        //unMarskall
        InputStream is = new FileInputStream("merge.xml");
        Unmarshaller unmarshallerObj = jaxbContext.createUnmarshaller();
        Merge rA=(Merge) unmarshallerObj.unmarshal(is);
        //reJson
        System.out.println(objectMapper.writeValueAsString(rA));



    }
}
