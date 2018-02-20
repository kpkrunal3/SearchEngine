package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;

import logic.countmatch;

/**
 * Servlet implementation class mainController
 */
@WebServlet("/mainController")
public class mainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		out.println("<form>");
		out.println("<input type='text' name='sname'>");
		out.println("<input type='submit' value='submit'>");
		out.println("</form>");
		doPost(request, response);*/
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*PrintWriter out=response.getWriter();
		String name=request.getParameter("sname");
		fileread fileread1=new fileread();
		int s1= fileread1.main(name);
		out.print("<a href='#'>1.html</a>");
		out.println("Number of count="+s1);
		out.println("<br/>Number of countvhjjas asjd sad asd sad asd adasd sadkjkjsajkd ");
		out.println("<br/>Number of countvhjjas asjd sad asd sad asd adasd sadkjkjsajkd ");
		out.println("<br/>Number of countvhjjas asjd sad asd sad asd adasd sadkjkjsajkd ");
		out.println("<br/>Number of countvhjjas asjd sad asd sad asd adasd sadkjkjsajkd ");*/
		String flag=request.getParameter("flag");
		if(flag.equals("tname")){
			doSearch(request,response);
		}
	}

	private void doSearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String sname=request.getParameter("sname");
		String[] countarray=sname.split(" ");
		for(int i=0;i<countarray.length;i++){
			if(countarray[i].contains("frequency")){
				Map<String, Integer> hashMap= new HashMap<String,Integer>();
				countmatch c1= new countmatch();
				String name=countarray[0].toString();
				c1.countsearch(name);
				/*request.getSession().setAttribute("frequency",hashMap);
				response.sendRedirect("frequencypage");*/
				/*for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
				    String key = entry.getKey();
				    Integer tab = entry.getValue();
				    // do something with key and/or tab
					System.out.println(entry.getKey()+"*****"+entry.getValue());
				}*/
				break;
			}
			else if(countarray[i].contains("consist")){
				countmatch c1= new countmatch();
				String name=countarray[0].toString();
				c1.puralsearch(name);
				break;
			}
			
			else if(countarray[i].contains("editdistance")){
				HashMap<String,Integer> hashMap= new HashMap<String,Integer>();
				String[] matchingword;
				countmatch c1= new countmatch();
				String name=countarray[0].toString();
				
				ArrayList<String> arrayList = new ArrayList<String>();
				File folder = new File("C:\\Users\\Krunal\\Krunal\\computing\\src\\textfile\\");
				File[] listOfFiles = folder.listFiles();
				
				 for (int k = 0; k < listOfFiles.length; k++) {
				      if (listOfFiles[k].isFile()) {
				    	  arrayList.add("C:\\Users\\Krunal\\Krunal\\computing\\src\\textfile\\"+listOfFiles[k].getName());
				       // System.out.println( listOfFiles[i].getName());
				      } 
				      }
				 for(int j=0;j<arrayList.size();j++){
					 org.jsoup.nodes.Document doc1 = Jsoup.parse(new File(arrayList.get(i)), "UTF-8", "www.w3sfjj.com");
					 String text = doc1.text();
					 matchingword=text.split(" ");
					 for(int l=0;l<matchingword.length;l++){
						 int a=c1.minDistance(name, matchingword[l]);
						 hashMap.put(matchingword[l],a);
					 }
					 
				 }
		         Map<Integer, String> map = sortByValues(hashMap); 
		         Set set2 = map.entrySet();
		         Iterator iterator2 = set2.iterator();
		         String[] words= new String[5];
		         int kp=0;
		         System.out.println("====================================");
		         System.out.println("List of related words of given word");
		         System.out.println("====================================");
		         while(iterator2.hasNext() && kp<5) {
		        	 Map.Entry me2 = (Map.Entry)iterator2.next();
		        	 //me2.getKey();
		        	 if(kp<5){
		        		 
		        		 System.out.println(me2.getKey());
		        		 kp++;
		        	 }
		        	 else{
		        		 
		        	 }
		         }
		         /*for(int q=0;q<words.length;q++){
		        	 System.out.println(words[q]);
		         }*/
				 break;
			}
		}
		
	}

	private static HashMap sortByValues(HashMap map) {
		List list = new LinkedList(map.entrySet());
	       // Defined Custom Comparator here
	       Collections.sort(list, new Comparator() {
	            public int compare(Object o1, Object o2) {
	               return ((Comparable) ((Map.Entry) (o1)).getValue())
	                  .compareTo(((Map.Entry) (o2)).getValue());
	            }
	       });
	       
	       // Here I am copying the sorted list in HashMap
	       // using LinkedHashMap to preserve the insertion order
	       HashMap sortedHashMap = new LinkedHashMap();
	       for (Iterator it = list.iterator(); it.hasNext();) {
	              Map.Entry entry = (Map.Entry) it.next();
	              sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       System.out.println();
	       return sortedHashMap;	}

}
