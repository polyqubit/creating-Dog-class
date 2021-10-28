import java.util.Scanner;

public class Main{
	public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int cPet = 0;
    System.out.println("Welcome to PetCo! Are you here to adopt an animal?\n[Type 1,2, or 3 for a dog, cat, or bird, or any other letter to quit.]");
    String inp = sc.nextLine();
	  int adorpt = 0;
    if(inp.equals("1")||inp.equals("2")||inp.equals("3")) {
      switch(inp) {
        case "1":
          System.out.println("Great! Follow me this way");
          Dog A = new Dog("A",0);Dog B = new Dog("B",0);Dog C = new Dog("C",0);
          A.setGenome();B.setGenome();C.setGenome();
          while(true) {
            System.out.println("We have 3 newborn pups for you to take a look at:\n[Type 1,2,3 to look at each]");
		        inp = sc.nextLine();
            System.out.println("Good Choice!");
            switch(inp) {
              case "1":
                System.out.println("Here we have a "+A.readStat(4)+" "+A.readStat(1));
                adorpt = 1;
              break;
              case "2":
                System.out.println("Here we have a "+B.readStat(4)+" "+B.readStat(1));
                adorpt = 2;
              break;
              case "3":
                System.out.println("Here we have a "+C.readStat(4)+" "+C.readStat(1));
                adorpt = 3;
              break;
            }
            System.out.println("\nHave you made a choice or would you like to keep looking?\n[Type 0 to adopt this dog, or anything else to continue]");
            inp = sc.nextLine();
            if(inp.equals("0")) {
              break;
            }
          }
          Dog adopted;
          switch(adorpt) {
            case 1:
              System.out.println("You've adopted a "+A.readStat(1)+"!\nWhat would you like to name your dog?");
              inp = sc.nextLine();
              
            break;
            case 2:
              System.out.println("You've adopted a "+B.readStat(1)+"!\nWhat would you like to name your dog?");
            break;
            case 3:
              System.out.println("You've adopted a "+C.readStat(1)+"!\nWhat would you like to name your dog?");
            break;
          }
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
