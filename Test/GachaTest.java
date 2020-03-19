import com.okabe.Gacha;
import jdk.jfr.StackTrace;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GachaTest {
    @Test
    public void doGachaTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //テスト対象メソッド呼び出し
        try {
            Gacha.doGacha(10, 3);
        } catch (Exception e) {
            System.out.println("doGachaでエラー");
        }
        String outPutLog = out.toString();
        assertThat(outPutLog.substring(outPutLog.length() - 4), is("END" + System.lineSeparator()));
    }

    @Test
    public void getGachaItemTest() {
        String itemName = null;

        try {
            itemName = Gacha.getGachaItem(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //テスト対象メソッド呼び出し
        System.out.println(itemName);

        //todo 期待値を書く
    }
}