package comunicare;

public class T1 implements Runnable {

    Chat chat;
    String[] questions = {"Hy",
            "How are you?",
            "I am also doing fine!"};

    @Override
    public void run() {
        for(String temp : questions){
            chat.question(temp);
        }
    }

    public T1(Chat chat) {
        this.chat = chat;
        new Thread(this, "Question-Thread").start();
    }
}
