package mock;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SecurityCenterTest {
    /* 需求描述：
    编写SecurityCenter类的单元测试
    原理：该需求需要确定switchOn()方法是否可以执行，其中又运行了底层的doorPanel.close()方法。因此可以mock doorPanel重写
    close方法以确定其可以运行。
    * */

    //Mock doorPanel -> 不使用doorPanels
    class MockDoorPanel extends DoorPanel {
        private boolean isCalled = false;

        void close() {
            isCalled = true;
        }

        boolean getCalled() {
            return isCalled == true;
        }
    }

    private MockDoorPanel mock;
    private SecurityCenter securityCenter;

    @BeforeEach
    public void setUp() {
        mock = new MockDoorPanel();
        securityCenter = new SecurityCenter(mock);
    }

    @Test
    public void shouldVerifyDoorIsClosed() {
        securityCenter.switchOn();
        Assertions.assertEquals(true, mock.getCalled());
    }
}
