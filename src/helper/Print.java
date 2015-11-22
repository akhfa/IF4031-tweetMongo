package helper;

/**
 * Created by akhfa on 23/11/15.
 */
public class Print {
    public static void guestHelp()
    {
        System.out.println("To register,    ketik: reg [username] [password]");
        System.out.println("To login,       ketik: login [username] [password]");
        System.out.println("To exit,        ketik: exit");
    }

    public static void userHelp()
    {
        System.out.println("To follow,          ketik: follow [username]");
        System.out.println("To send tweet,      ketik: tweet [body]");
        System.out.println("To see userline,    ketik: userline");
        System.out.println("To see timeline,    ketik: timeline");
        System.out.println("To logout,          ketik: logout");
    }
}
