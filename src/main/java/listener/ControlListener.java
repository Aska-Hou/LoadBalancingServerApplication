package listener;

import Domain.LoadingResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import service.WeightCalculationService;
import utils.HttpUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ControlListener implements ServletContextListener {

    WeightCalculationService weightCalculationService = new WeightCalculationService();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        for (int i = 0; i < 2; i++){
//            Leng Server
            LoadingResult server1Result = getCurrentCondition("http://120.78.176.205:8080/ApplicationServerTomcat-1.0-SNAPSHOT/application1/getCurrentLoading");
//            Wang Server
            LoadingResult server2Result = getCurrentCondition("");

            int[] weights = weightCalculationService.calculateWeight(server1Result, server2Result);

            HttpUtil.sendGet("http://localhost:8500/", "weight");

        }


    }

    public LoadingResult getCurrentCondition(String url){
        String str1 = HttpUtil.sendGet(url, "");
        ObjectMapper mapper = new ObjectMapper();
        LoadingResult result = null;
        try {
            result = mapper.readValue(str1, LoadingResult.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
