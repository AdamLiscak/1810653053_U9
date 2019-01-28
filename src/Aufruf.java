import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Aufruf {
    public static void main(String[] args) throws Exception
    {

        ObjectMapper objectMapper=new ObjectMapper();
        Merge a = objectMapper.readValue(new File("src/merge.json"), Merge.class);
        System.out.println(a.toString());
        //marskall
        JAXBContext jaxbContext     = JAXBContext.newInstance( Merge.class );
        Marshaller jaxbMarshaller   = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        OutputStream os = new FileOutputStream( "employee.xml" );
        jaxbMarshaller.marshal( a, os );



    }
}
