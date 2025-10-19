package calculator;

public class StringAddCalculator {
    public static int add(final String text) {
        if(text == null || text.isEmpty()){
            return 0;
        }

        int result;
        if(text.startsWith("//")){ //커스텀 구분자를 갖는 문자열
            result = addWithCustomDelimiter(text);
        } else{ //쉼표 또는 콜론을 구분자로 갖는 문자열
            result = addWithDefaultDelimiter(text);
        }

        return result;
    }

    private static int addWithDefaultDelimiter(String text) {
        String[] tokens = text.split(",|:");

        return textToInt(tokens);
    }

    private static int addWithCustomDelimiter(String text){
        String customDelimiter = delimiterExtraction(text);

        text = text.substring(text.indexOf('\n') + 1);
        String[] tokens = text.split(customDelimiter);

        return textToInt(tokens);
    }

    private static int textToInt(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            if(token.isEmpty()){
                continue;
            }

            int number = Integer.parseInt(token);

            if(number < 0){
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                //종료해야 함
            }

            sum += number;
        }

        return sum;
    }

    private static String delimiterExtraction(String text){
        int indexOfDel = text.indexOf('\n');

        return text.substring(2, indexOfDel);
    }
}