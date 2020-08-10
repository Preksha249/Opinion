//import java.util.Scanner;
public class SentimentAnalysis {

    public void sentiana(String san) {
         
      //System.out.println("enter the sentence");
      //  Scanner in =new Scanner(System.in);
          try {  
        	  	         	  
        String text=san;	  
       // String text = "you are really very worst\n";

        
        SentimentAnalyser sentimentAnalyzer = new SentimentAnalyser();

        sentimentAnalyzer.initialize();

        SentimentResult sentimentResult = sentimentAnalyzer.getSentimentResult(text);

      //   @SuppressWarnings("unused")
		String res = sentimentResult.getSentimentType();
         
		// String type = sentimentResult.getSentimentType();
		  //System.out.println("ok "+res);
        try {
        	//System.out.println("okk in ");
        	 if(res.equals("Positive"))
        	 { posit p = new posit();
        	   p.collect();
        	 }
        	 else if(res.equals("Negative"))
        	 { negat n = new negat();
        	   n.collect();
        	 } 	
        	 else if(res.equals("Neutral"))
        	 { neut nt = new neut();
        	   nt.collect();
        	 }
        	 else if(res.equals("Very Positive"))
        	 {
        		 vposit vp = new vposit();
        		 vp.collect();
        	 }
 		//sc.close();
        	//  System.out.println("ok2 ");
 		
 		// TODO Auto-generated method stub
 	
 		} finally{}

        
      } finally// {
         //  in.close(); }  
          { }
    }

}
