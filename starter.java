import java.util.Scanner;

public class starter{
	public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
	System.out.println("Unfinished items:\nMultiple pets\nOther animals\nMinigames\n");
    System.out.println("Welcome to PetCo! Are you here to adopt an animal?\n[Type 1,2, or 3 for a dog, cat, or bird, or any other letter to quit.]");
    String inp = sc.nextLine();
	  int adorpt = 0;
    if(inp.equals("1")||inp.equals("2")||inp.equals("3")) {
      switch(inp) {
        case "1":
          System.out.println("Great! Follow me this way");
          Dog A = new Dog("A",1);Dog B = new Dog("B",1);Dog C = new Dog("C",1);
          A.setGenome();B.setGenome();C.setGenome();
          while(true) {
            System.out.println("We have 3 dogs for you to take a look at:\n[Type 1,2,3 to look at each]");
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
          Dog adopted = new Dog("D",1);
          switch(adorpt) {
            case 1:
              System.out.println("You've adopted a "+A.readStat(1)+"!\nWhat would you like to name your dog?");
			  adopted.editGenome(A.readGenome(false));
            break;
            case 2:
              System.out.println("You've adopted a "+B.readStat(1)+"!\nWhat would you like to name your dog?");
			  adopted.editGenome(B.readGenome(false));
            break;
            case 3:
              System.out.println("You've adopted a "+C.readStat(1)+"!\nWhat would you like to name your dog?");
			  adopted.editGenome(C.readGenome(false));
            break;
          }
		  inp = sc.nextLine();
		  while(inp.equals("")) {
			  System.out.println("Invalid name. Enter a new one");
			  inp = sc.nextLine();
		  }
          adopted.rename(inp);
		  System.out.println("Congratulations on adopting a dog! Would you like to hear about its personality?\n[Press 1 to read its summary or anything else to continue]");
		  inp = sc.nextLine();
		  if(inp.equals("1")){
			adopted.summary();
		  }
		  //activities
		  while(true) {
			  System.out.println("\nWhat would you like to do with "+adopted.readStat(0)+"?");
			  System.out.println("[Options: feed, teach, play, rest, exit]");
			  inp = sc.nextLine();
			  switch(inp) {
				  case "feed":
					System.out.println("You feed "+adopted.readStat(0)+".");
					adopted.hunger += 20;
					if(adopted.hunger > 255) {
						adopted.hunger = 255;
						if(adopted.hunger>270) {System.out.println(adopted.readStat(0)+" is full!");}
					}
				  break;
				  case "teach":
					System.out.println("\nWhat will you teach "+adopted.readStat(0)+"?\n[Options: fetch, barrel roll, stand, jump, high five, tug of war]");
					adopted.teachSkill(sc.nextLine());
				  break;
				  case "play":
					System.out.println("\nWhat would you like to play with "+adopted.readStat(0)+"?\n[Options: fetch, barrel roll, stand, jump, high five, tug of war]");
					adopted.play(sc.nextLine());
				  break;
				  case "rest":
					System.out.println(adopted.readStat(0)+" rests up.");
					adopted.stamina += 40;
					if(adopted.stamina > 255) {adopted.stamina = 255;}
				  break;
			  }
			  if(inp.equals("exit")||adopted.hunger==0) {System.out.println(adopted.readStat(0)+" is sad to see you go.");break;}
			  if((adopted.hunger==0)||(adopted.stamina==0)) {System.out.println(adopted.readStat(0)+" passes out from overexertion.");break;}
			  else if(adopted.stamina<60) {System.out.println(adopted.readStat(0)+" is getting tired...maybe you should give them a break.");}
			  else if(adopted.hunger<60) {System.out.println(adopted.readStat(0)+" is getting hungry...maybe you should give "+adopted.g1+" a treat.");}
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
