package exceptions;


class WsizException extends RuntimeException {

}

public class A {
    public static void main(String[] args) {
        String ww = "11";
        int x = 0;
        try {
            x = Integer.valueOf(ww);
            throw new WsizException();
        } catch (NumberFormatException e) {
            System.out.println("Nie da się zamienić");
        } catch (WsizException e) {
            System.out.println("Błąd customowy (nasz)");
        }


        System.out.println(x);
        NumberFormatException e;

    }
}
