package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int add(final String text) {
        int result;
        if(text.startsWith("//")){ //커스텀 구분자를 갖는 문자열
            result = addWithCustomDelimiter(text);
        } else{ //쉼표 또는 콜론을 구분자로 갖는 문자열
            result = addWithDefaultDelimiter(text);
        }

        return result;
    }

    private static int addWithDefaultDelimiter(String text) {
        String[] tokens = text.split("[,:]");

        return textToInt(tokens);
    }

    private static int addWithCustomDelimiter(String text){
        Pattern pattern = Pattern.compile("//(.*?)\\\\n"); //커스텀 구분자 패턴을 찾는 정규표현식
        Matcher matcher = pattern.matcher(text);

        if(matcher.find()){
            String customDelimiter = matcher.group(1);

            if(customDelimiter.isEmpty()){
                throw new IllegalArgumentException("커스텀 구분자가 존재하지 않습니다.");
            }

            String numWord = text.substring(matcher.end());
            String[] tokens = numWord.split(Pattern.quote(customDelimiter));

            return textToInt(tokens);
        }

       return 0;
    }

    private static int textToInt(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            String trimmedToken = token.trim();

            if(!token.equals(trimmedToken)){
                throw new IllegalArgumentException("공백이 포함될 수 없습니다.");
            }

            int number = Integer.parseInt(trimmedToken);

            if(number < 0){
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }

            sum += number;
        }

        return sum;
    }
}