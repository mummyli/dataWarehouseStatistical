import com.wondersgroup.cd.etlgroup.utils.PropertiesReader;
import org.junit.Test;

/**
 * Created by lsj on 2017-7-18.
 */

public class PropertiesReaderTest {

    @Test
    public void loadsTest(){
        PropertiesReader.loads();
    }

    @Test
    public void readPropert(){
        System.out.println(PropertiesReader.read("conf")+"\n"+PropertiesReader.read("sqlBase"));
    }
}
