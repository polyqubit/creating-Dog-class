import java.util.Random;
public class Dog {
  private String name,breed,tA,tB;
  private int age,data,genome;
  private boolean genomeInitialized = false;
  private Random rand = new Random();
  /**
    GENE description(starting from least sig):
    breed/species
    trait(described bottom of file)
    secondary trait
    gender
  **/
  /**
    DATA description(starting from least sig)
    hunger value
    friend value
    stamina
    activity
  **/
  /**
    SKILLS are stored in arrays, which are:
    0 - name recognition
    1 - 
    2 - 
    3 - 
    4 - 
    5 - 
    6 - 
    7 - 
    8 - 
    9 - 
    A - 
    B - 
    C - 
    D - 
    E - 
    F - 
  **/
  public Dog() {
    name = new String("Clifford");
    age = 3;
    genome = 0x0100;
  }
  public Dog(String name) {
    this.name = name;
    age = 0;
    genome = 0x0000;
  }
  public Dog(String name, int age) {
    this.name = name;
    this.age = age;
    genome = 0x0000;
  }
  public void setGenome() {
    genome = rand.nextInt(65536);
    genomeInitialized = true;
  }
  public void editGenome(int genome) {
    if(genomeInitialized){
      this.genome = genome;
    }
  }
  public void readGenome() {
    if(genomeInitialized){
      System.out.println(String.format("0x%08X", genome));
    }
  }
  public void rename(String name) {
    this.name = name;
  }
  public int nibbleExtract(int inp, int digit) {
    int bit = inp >> (digit-1)*4;
    return bit & 0x000F;
    //return bit;
  }
  public void summary() {
    //NOOO I DONT WANT TO DO 500 SWITCH STATEMENTS
    //oh well
    if(genomeInitialized){
      int b = nibbleExtract(genome, 1);
      switch(breed) {case}
      System.out.println("w");
    }
  }
}

/**
0 - competititve, takes 0.5x as many repetitions to teach a trick and gains 1.5x more friendship from activities if another dog is present
1 - friendly, gains friendship 2x faster from all sources
2 - glutton, hunger gain 2x faster
3 - aggressive, gains friendship 0.5x as fast
4 - stubborn, takes 1.5x as many repetitions to teach a trick
5 - hyperactive, gains 2x friendship from activities
6 - mrpoole, plays LoL
7 - muscular, 1.5x stamina, 1.5x friendship from activities
8 - smart, takes 0.5x as many repetitions to teach a trick
9 - lazy, gains 0.5x as much friendship from activities, 0.75x stamina
**/