package calculator;

public class StringAddCalculator {
    public static int add(final String text) throws IllegalAccessException {
        if(text == null || text.isEmpty()){
            return 0;
        }

        //쉼표 또는 콜론을 구분자로 갖는 문자열
        String[] tokens = text.split(",|:");
        int result = textToInt(tokens);

        return result; //임시 리턴값
    }

    private static int textToInt(String[] tokens) throws IllegalAccessException {
        int sum = 0;
        for (String token : tokens) {
            if(token.isEmpty()){
                continue;
            }

            int number = Integer.parseInt(token);

            if(number < 0){
                throw new IllegalAccessException("음수는 입력할 수 없습니다.");
                //종료해야 함
            }

            sum += number;
        }

        return sum;
    }

}