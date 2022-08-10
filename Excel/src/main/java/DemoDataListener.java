import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class DemoDataListener implements ReadListener<DemoData> {

    private static final int BATCH_COUNT = 100;

    private List<DemoData> cacheDataList = new ArrayList<DemoData>(BATCH_COUNT);

    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        System.out.println(String.format("解析到一条数据:{}", JSON.toJSONString(demoData)));
        cacheDataList.add(demoData);
        saveData();

        if (cacheDataList.size() >= BATCH_COUNT){
            cacheDataList = new ArrayList<DemoData>(100);
        }
    }

    private void saveData() {
        for(int i = 0; i < cacheDataList.size(); ++i){
            System.out.println("存储数据：" + JSON.toJSONString(cacheDataList.get(i)));
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        System.out.println("所有数据解析结束!");
    }
}
