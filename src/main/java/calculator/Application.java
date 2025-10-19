package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String text = Console.readLine();

        try{
            int result = StringAddCalculator.add(text);
            System.out.printf("결과 : %d\n", result);
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR]" + e.getMessage());
        }

    }
}
