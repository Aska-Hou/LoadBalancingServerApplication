import org.junit.Test;
import utils.HttpUtil;

public class PostSendingTest {


    @Test
    public void Test(){
        String result = HttpUtil.sendPost("http://120.78.176.205:8080/ApplicationServerTomcat-1.0-SNAPSHOT/application1/getCurrentLoading", "");
        System.out.println(result);
    }
}
