public class SingBirthday{
	
		public static void singHappyBirthday(String name, int age) // Not needed, only used to check proper syntax of write method
		{
			System.out.println("Happy Birthday to you!");
			System.out.println("Happy Birthday to you!");
			System.out.println("Happy Birthday dear " + name + "!");
			System.out.println("Happy Birthday to you!");
		
			if(age%10 == 1)
			{
				System.out.println("Happy " + age + "st birthday!"); //st
			}
			else if (age%10 == 2)
			{
				System.out.println("Happy " + age + "nd birthday!"); //nd
			}
			else if (age%10 == 3)
			{
				System.out.println("Happy " + age + "rd birthday!"); //rd
			}
			else
			{
				System.out.println("Happy " + age + "th birthday!"); //th
			}
			return;
		}
		
		public static String writeHappyBirthday(String name, int age)
		{
			Sting song;
			
			if(age%10 == 1) //1st
			{
				song = "Happy Birthday to you! \n Happy Birthday to you! \n Happy Birthday dear" 
						+ name + "!\n Happy Birthday to you! \n Happy " + age + "st birthday!";
			}
			else if (age%10 == 2) //2nd
			{
				song = "Happy Birthday to you! \n Happy Birthday to you! \n Happy Birthday dear" 
						+ name + "!\n Happy Birthday to you! \n Happy " + age + "nd birthday!";
			}
			else if (age%10 == 3) //3rd
			{
				song = "Happy Birthday to you! \n Happy Birthday to you! \n Happy Birthday dear" 
						+ name + "!\n Happy Birthday to you! \n Happy " + age + "rd birthday!";
			}
			else // 4-0th
			{
				song = "Happy Birthday to you! \n Happy Birthday to you! \n Happy Birthday dear" 
						+ name + "!\n Happy Birthday to you! \n Happy " + age + "th birthday!";
			}
			
			return song;
		}
		
		public static void main(String[] args)
		{
			String bDaySong;
			
			bDaySong = writeHappyBirthday(＂William＂+＂ ＂+＂Honig＂, 21);
			singHappyBirthday(＂William＂+＂ ＂+＂Honig＂, 21);
			
			System.out.println(bDaySong);
		}
}