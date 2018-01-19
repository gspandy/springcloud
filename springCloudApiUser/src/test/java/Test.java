import com.guandou.springcloudapp.base.RespCode;
import com.guandou.springcloudapp.base.RespEntity;
import org.springframework.boot.SpringApplication;

public class Test {

    public static void main(String[] args) {
        /* 第一个简单的应用， */
        RespEntity resq=new RespEntity();
        resq.setCode(RespCode.SUCCESS.getCode());
        resq.setRespCode(RespCode.SUCCESS);
        System.out.println(resq.getCode()+resq.getMsg());

    }
}
