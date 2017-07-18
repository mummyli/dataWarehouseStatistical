package com.wondersgroup.cd.etlgroup.utils;

import com.wondersgroup.cd.etlgroup.model.StatisticConfModel;
import com.wondersgroup.cd.etlgroup.model.ViewModel;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lsj on 2017-7-18.
 */
public class XMLPharser {

    private static final String CONF_XML = PropertiesReader.read("conf");
    private static Element root = null;

    static {
        initRootElement();
    }

    public static void initRootElement() {
        SAXReader reader = new SAXReader();
        Document doc;

        try {
            InputStream in = new FileInputStream(new File(CONF_XML));
            doc = reader.read(in);
            root = doc.getRootElement();
        } catch (IOException ioe) {
            //log here
            ioe.printStackTrace();
        } catch (DocumentException doce) {
            //log here
            doce.printStackTrace();
        }

    }

    public static List<ViewModel> getViewModel(Element element, String elementSelect) {
        List<ViewModel> vmList = new LinkedList<ViewModel>();

        if (root == null) initRootElement();
        if (element == null) element = root;

        List<Node> nodes = element.selectNodes(elementSelect);

        for(Node node : nodes){
            ViewModel vm  = new ViewModel();
            vm.setViewName(node.valueOf("@name"));
            vm.setFilePath(node.getText().trim());

            vmList.add(vm);
        }

        return vmList;
    }


    public static List<StatisticConfModel> getStatisticConf(Element element, String elementSelect){
        List<StatisticConfModel> scmList = new LinkedList<StatisticConfModel>();

        if(root == null) initRootElement();
        if(element == null) element = root;

        List<Element> stsElement = element.elements(elementSelect);

        for(Element e : stsElement){
            String baseName = e.attribute("id").getValue();

            Element viewsEle = e.element("views");
            List<ViewModel> vmList = getViewModel(viewsEle,"view");

            List<Node> sqlEle = e.selectNodes("sql");
            List<String> sqls = new LinkedList<String>();

            for(Node n:sqlEle)
                sqls.add(n.getStringValue());

        }
        return scmList;
    }


    public Element getRoot(){
        return root;
    }
}
