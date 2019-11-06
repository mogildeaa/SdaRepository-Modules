package comunicare;

//Clasa chat: metode question, answer care sa conunice intre ele
public class Chat {

    //aceasta booleana e de obicei numita ca FLAG
    boolean isActionUnavailable = false;

    synchronized void question(String question) {

        if (isActionUnavailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(question);
        isActionUnavailable = true;
        notify();
    }

    synchronized void answer(String answer) {
        if (!isActionUnavailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(answer);
        isActionUnavailable = false;
        notify();
    }
}
