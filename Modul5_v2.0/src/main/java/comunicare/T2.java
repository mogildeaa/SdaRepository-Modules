package comunicare;

public class T2 implements Runnable {

    Chat chat;

    String[] answers = {"Hi",
            "I am good",
            "Great"};
    @Override
    public void run() {
        for(String temp: answers){
            chat.answer(temp);
        }
    }

    public T2(Chat chat) {
        this.chat = chat;
        new Thread(this, "Answers-Thread").start();
    }


}
