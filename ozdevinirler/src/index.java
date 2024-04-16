import java.util.Scanner;

public class index {
    public static boolean isValidExpression(String expression) {
        int openParentheses = 0;
        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                openParentheses++;
            } else if (ch == ')') {
                openParentheses--;
            }

            if (openParentheses < 0) {
                return false; // Parantez siralamasi
            }
        }
        return openParentheses == 0;
    }

    public static boolean recognize(String expression) {
        // Bölme işlemi varsa ve 0'a bölünüyorsa false
        if (expression.contains("/ 0") || expression.contains("/0")) {
            return false;
        }

        // ifade doğru ise true
        return isValidExpression(expression);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Matematiksel ifade giriniz:");
        String expression = scanner.nextLine();
        if (recognize(expression))
            System.out.println("'" + expression + "' matematiksel ifadedir.");
        else
            System.out.println("'" + expression + "' matematiksel ifade değildir"
            		+ ".");
        scanner.close();
    }
}