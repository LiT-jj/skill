import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;

public class ReadTest {

    public void simpleRead(String path){
        EasyExcel.read(path, DemoData.class, new PageReadListener<DemoData>(demoDataList -> {
            for (DemoData data: demoDataList){
                System.out.println("存储数据：" + JSON.toJSONString(data));
            }
        })).sheet().doRead();
    }
}

class Test{

}
