public class Main {

    public static void main(String[] args) {
        int counter = 0;

        for (Secret secret: Secret.values()) {

            if (secret.name().startsWith("STAR")) {
                counter++;

//                System.out.println(secret);
            }

        }

//        for (int i = 0; i < Secret.values().length; i++) {
//            if (Secret)
//        }

        System.out.println(counter);

    }
}

// sample enum for inspiration
//   enum Secret {
//    STAR, CRASH, START, // ...
//}

