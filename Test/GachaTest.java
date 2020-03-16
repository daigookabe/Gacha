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
    public void getNormalGachaItemTest() {
        String normalName = null;

        try {
            normalName = Gacha.getNormalGachaItem(50);
        } catch (Exception e) {
            System.out.println("getNormalGachaItemでエラー");
        }
        //テスト対象メソッド呼び出し
        System.out.println(normalName);

        //todo 期待値を書く
    }

    @Test
    public void getSpecialGachaItemTest() {
        String normalName = null;

        try {
            normalName = Gacha.getSpecialGachaItem(50);
        } catch (Exception e) {
            System.out.println("getSpecialGachaItemでエラー");
        }
        //テスト対象メソッド呼び出し
        System.out.println(normalName);

        //todo 期待値を書く
    }

}