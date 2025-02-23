import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UpperCaseCounterTest {

    private UpperCaseCounter upperCaseCounter = new UpperCaseCounter();

    //null을 전달했을 때 0을 리턴하는지에 대한 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_0_for_null_input(){
        String str = null;                                                                                            // 직접 NULL 값을 넣어주고 0이 나오는지 확인

        int numberOfUpperCaseCharInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        //System.out.println("result ::" + numberOfUpperCaseCharInString);                                             //눈으로 직접 확인
        assertTrue(numberOfUpperCaseCharInString==0);                                                         //직접 확인
    }

    //빈값을 전달했을 때 0을 리턴하는지에 대한 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_0_for_empty_input() {
        String str = "";
        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertTrue(numberOfUpperCaseCharactersInString==0);
    }

    //대문자들이 포함된 문자열을 전달했을 때 카운팅된 숫자와 맞는지 검증하는 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_10_for_ABCDEFGHIJ() {
        String str = "ABCDEFGHIJ";

        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);

        //assertTrue로 맞는 테스트 코드 작성
        //assertTrue(numberOfUpperCaseCharactersInString==10);

        //assertFalse로 틀리는 값을 넣어 테스트 작성
        //assertFalse(numberOfUpperCaseCharactersInString==9);

        //assertThat 단정문을 사용해서 True인 테스트 코드 작성
        assertThat(numberOfUpperCaseCharactersInString,is(10));
    }

    //대소문자가 섞여 있을 때 정확히 카운팅 되는 지에 대한 테스트 코드 작성
    @Test
    public void getNumberOfUpperCaseCharacterInString_return_6_for_ABCdefGHI(){
        String str = "ABCdefGHI";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        //assertTrue로 맞는 테스트 코드 작성
        //assertTrue(result==5);
        //assertFalse로 틀리는 값을 넣어 테스트 작성
        //assertFalse(result==9);
        //assertThat 단정문을 사용해서 True인 테스트 코드 작성
        assertThat(result,is(6));
        System.out.println("result :: " + result);
    }

    //잘못된 값을 참조했을 때 IndexOutOfBoundsException Exception이 발생하는지 테스트 코드 작성
    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenGetZeroIndex() {
        new ArrayList<Object>().get(0);
    }

    //해당 메소드가 제한된 시간내에 실행되는지에 대한 테스트 코드 작성 : timeout 사용
    //두번째로 해당 메소드는 테스트 하지 않도록 어노테이션 추가 적용 해봅니다. Ignore
    @Test(timeout = 5000)
    public void testShouldRunInLimitedTime() throws InterruptedException {
        Thread.sleep(4000);                                                     //5000시간 안에 수행되어야하는데 4000후에 수행되므로 Passed
        System.out.println("제한된 시간 내에 수행되면 테스트 Passed!");
    }
}
