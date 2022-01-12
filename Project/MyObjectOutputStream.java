package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream {
    public MyObjectOutputStream() throws IOException{
        super();
    }
    public MyObjectOutputStream(OutputStream o) throws IOException, IOException {
        super(o);
    }
    public void writeStreamHeader(){

    }

}
