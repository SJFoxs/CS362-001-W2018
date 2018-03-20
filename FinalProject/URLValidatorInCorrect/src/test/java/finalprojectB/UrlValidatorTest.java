
package finalprojectB;

import java.io.IOException;

import java.util.Random;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
	   UrlValidator UrlVal = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);

	   System.out.println("http://www.google.com " + UrlVal.isValid("http://www.google.com"));
	   System.out.println("www.amazon.com " + UrlVal.isValid("www.amazon.com"));
	   System.out.println("http://www.google.com: " + UrlVal.isValid("http://www.google.com:"));
	   System.out.println("http://www.netflix.com " + UrlVal.isValid("http://www.netflix.com"));
	   System.out.println("http://www.google.com/?action=view " + UrlVal.isValid("http://www.google.com/?action=view"));
	   System.out.println("file://localhost:8080 " + UrlVal.isValid("http://asdf"));
   }
   
   
   public void testYourFirstPartition()
   {
	   String[][] schemes = new String[3][];
	   String[] scheme00 = {"http", "ftp", "https"};
	   String[] scheme01 = {""};
	   String[] scheme02 = {"http", "100", "."};
	   schemes[0] = scheme00;
	   schemes[1] = scheme01;
	   schemes[2] = scheme02;
	   
	   long[] options = new long[3];
	   long option00 = UrlValidator.ALLOW_2_SLASHES+UrlValidator.ALLOW_ALL_SCHEMES+UrlValidator.ALLOW_LOCAL_URLS+UrlValidator.NO_FRAGMENTS;
	   long option01;
	   long option02 = 8;
	   options[0] = option00;
	   //options[1] = option01;
	   options[2] = option02;
	   
	   String[] urlString = new String[3];
	   urlString[0] = "http:/www.google.com";
	   urlString[1] = "ftp:/chase:500";
	   urlString[2] = "file:steve.txt";
	   
	   //RegexValidator reg00 = new RegexValidator(UrlValidator.PATH_REGEX);
	 //You can use this function to implement your First Partition testing	   
	 try {
		 UrlValidator urlV = new UrlValidator(null);
		 for(int i=0; i<3; i++) {
			 for(int x=0; x<3; x++) {
				 for(int y=0; y<3; y++) {
					 urlV = new UrlValidator(schemes[i], options[x]);
					 System.out.println(urlString[y] + ": " + urlV.isValid(urlString[y]));
				 }
			 }
			 
		 }
	 } catch(Exception e) {
		 System.err.println("Failure");
		 e.printStackTrace();
	 }

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	 
		UrlValidator URL = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

	    String[] Scheme = {
	    		"http://", 
	    		"3ht://", 
	    		"http:/", 
	    		"http:", 
	    		"://", 
	    		""};
	    String[] Authority = {
	    		"www.google.com", 
	    		"netflix.com", 
	    		"google.sp", 
	    		"1.1.1.1", 
	    		"asdf.com"};
	    String[] Path = {
	    		"/asdf", 
	    		"/$12", 
	    		"/..", 
	    		"/../", 
	    		"/test1/", 
	    		"", 
	    		"/asdf/asdf", 
	    		"/..//file", 
	    		"/asdf//file", 
	    		"/#"};
	    String[] Port = {
	    		":8080", 
	    		":65535", 
	    		":0", 
	    		"", 
	    		":-1", 
	    		":65636", 
	    		":xyz"};
	    String[] Query = {
	    		"?action=view", 
	    		"?action=edit&mode=up", 
	    		""};

	    for(int a = 0; a < Scheme.length; a++) {
	      for(int b = 0; b < Authority.length; b++) {
	        for(int c = 0; c < Path.length; c++) {
	          for(int d = 0; d < Port.length; d++) {
	            for(int e = 0; e < Query.length; e++){
	              String string = Scheme[a] + Authority[b] + Path[c] + Port[d] + Query[e];
	                if(URL.isValid(string) == true) {
	                  System.out.println("url is valid: " + string);
	                }
	                else {
	                  //System.out.println("url is invalid: " + string);
					  //Too many invalids, print valids and work from there.
	                }
	            }
	          }
	        }
	      }
	    }

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   String[] schemes = {new String("http"), 
			   new String("git"), 
			   new String("ftp"), 
			   new String("file"),
			   new String("im"),
			   new String()};//6
	   long[] options = { 0l, 
			   UrlValidator.ALLOW_2_SLASHES, 
			   UrlValidator.ALLOW_ALL_SCHEMES,
			   UrlValidator.ALLOW_LOCAL_URLS,
			   UrlValidator.NO_FRAGMENTS};//5
	   String[] urlScheme = {new String(),
			   new String("http"),
			   new String("git"),
			   new String("ftp"),
			   new String("file"),
			   new String("im"),
			   new String("ham"),
			   new String("cid")};//7
	   String[] urlAuthority = {new String("www.google.com"),
			   new String("www.facebook.com"),
			   new String("www.youtube.com"),
			   new String("www.reddit.com"),
			   new String("www.gg.ca"),
			   new String("www.steve.txt"),
			   new String("www.lambda.jp")};//7
	   String[] urlPath = {new String(),
			   new String(":8000"),
			   new String("/"),
			   new String("/steve.txt"),
			   new String("/garblegarb"),
			   new String("/l33t"),
			   new String("/reeeeee!!!!!!!!!"),
			   new String("/clean/")};//8
	   //You can use this function for programming based testing
	   
	   UrlValidator uTest;
	   Random rand = new Random(System.currentTimeMillis());
	   
	   try {
		   for(int i=0; i<50; i++) {
			   long op = options[rand.nextInt(5)];
			   System.out.println("Test "+ (i+1)+ "\nTested with long option: "+op);
			   uTest = new UrlValidator(schemes, op);
			   String urlTest = urlScheme[rand.nextInt(7)] + "://" + urlAuthority[rand.nextInt(7)]+urlPath[rand.nextInt(8)];
			   System.out.print(urlTest + " : ");
			   System.out.println(uTest.isValid(urlTest)+ "\n");
		   }
	   } catch(IllegalArgumentException e) {
		   System.err.println("Crashed");
		   e.printStackTrace();
	   }

   }
   


}
