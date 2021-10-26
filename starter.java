import java.util.Scanner;

public class starter{
	public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to PetCo! Are you here to adopt an animal?\nType 1,2, or 3 for a dog, cat, or bird, or any other letter to quit.");
    String inp = sc.nextLine();
    if(inp.equals("1")||inp.equals("2")||inp.equals("3")) {
      switch(inp) {
        case "1":
          System.out.println("Great! Follow me this way.");
        break;
        case "2":
          System.out.println("Sorry, we don't have any of those at the moment...(i was lazy lol)");
        break;
        case "3":
          System.out.println("Sorry, we don't have any of those at the moment...(i was lazy lol)");
        break;
        //the other animals will be included when i feel like it
      }
    }
  }
}
