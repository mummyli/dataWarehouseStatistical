import com.wondersgroup.cd.etlgroup.model.ViewModel;
import com.wondersgroup.cd.etlgroup.utils.XMLPharser;
import org.junit.Test;

import java.util.List;

/**
 * Created by lsj on 2017-7-18.
 */
public class XMLPharetEST {


    @Test
    public void testViewList(){
        List<ViewModel> vmlist = XMLPharser.getViewModel(null,"//dics//views//view");
        for(ViewModel vm : vmlist){
            System.out.println(vm.getViewName()+"\t"+vm.getFilePath());
        }
    }

    @Test
    public void teststatisticConf(){
        XMLPharser.getStatisticConf(null,"sts");
    }
}
