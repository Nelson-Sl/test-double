package mock;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SecurityCenterTest {
    /* 需求描述：
    编写SecurityCenter类的单元测试
    原理：该需求需要确定switchOn()方法是否可以执行，其中又运行了底层的doorPanel.close()方法。因此可以mock doorPanel重写
    close方法以确定其可以运行。
    * */

    
    @Test
    public void shouldVerifyDoorIsClosed() {
        Mockito.verify(doorPanel).close();
        securityCenter.switchOn();
    }
}
