
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.NullPointerException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class project_file {
	public static void main(String args[]) throws IOException{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter path of the file");
		String s=scan.nextLine()	;
		FileInputStream in=new FileInputStream(s);
		
		int start;
		String path="";
		String path2="";
		while((start=in.read())!=10) {
			path=path+(char)start;
			
		}
		while((start=in.read())!=-1) {
			path2=path2+(char)start;
		}
		path2=path2.substring(0,path2.length()-2);
				recursive(path.substring(0,path.length()-1),path2.substring(0,path2.length()-2));
			if(in!=null) {
				in.close();
		
		}

	
	}
	public static void recursive(String directory,String path2) throws IOException
	{  
		

	    File fout=new File(path2);
		ArrayList<File> list=new ArrayList<File>();
		FileOutputStream out=new FileOutputStream(path2,true);
		BufferedWriter b=new BufferedWriter(new OutputStreamWriter(out));
		
		File file1=new File(directory);
		File[] files=file1.listFiles();
		for(File file:files) {
			if(file.isFile()) {
				list.add(file);
				
			}else if(file.isDirectory()){
					recursive(file.getAbsolutePath(),path2);
				}
			}
		try {
	     Iterator<File> itr=list.iterator();
		  while(itr.hasNext()){
			File f = itr.next();
		    b.write(" Name of the file --"+f.getName());
		    b.write(",");
		    b.write("Path --"+f.getAbsolutePath());
		    b.newLine();
		    b.newLine();
		}
		}catch(Exception e) {
		 System.out.println("Error");	
		}finally
		{
			
	if(b!=null) {
		b.close();
	}
	
	}
	
}
}