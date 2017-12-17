class BuggyBread { 
   public static void main(String[] args)
   {
      String s2 = "I am unique!"; 
      String s5 = "I am unique!";
      Integer i = new Integer(5);
      System.out.println(i.hashCode());
      System.out.println(null == null);
      
        //getDescription((Object)null);
      try {
		System.out.println(2 - 1.10);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
      
      
      
   } 
   
   public static String getDescription(Object obj){System.out.println("Object"); return obj.toString(); } 
   public static String[] getDescription(String[] obj){System.out.println("String[]"); return obj; }
   //public void getDescription(String obj){ return obj; }

   
}