public class Main {

    public static void main(String[] args) throws ArithmeticException{
        try{
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
        int c = calc.devide.apply(a, b);
        calc.println.accept(c);
        } catch(ArithmeticException e){
            System.out.println("Вероятно, вы делили на ноль, это нехорошо!!!");
        }
    }
}// Проблема была в том, что функция делила a на b, где b = 0. Решается это либо обработкой ошибки, как это сделано выше,
//либо простой проверкой на ноль делителя перед вызовом функции devide, либо в лямбда функции devide написать (x, y) -> y > 0 ? x / y : 0