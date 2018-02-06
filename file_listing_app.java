
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileInputStream;
import  java.lang.NullPointerException;

public class file_listing_app {
	public static void main(String args[]) throws IOException{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter path of file");
		String s= scan.nextLine();
		FileInputStream in=new FileInputStream(s);
		try {
		int start;
		String path="";
		while((start=in.read())!=10) {
			path=path+(char)start;
			
		}System.out.println(path);
		recursive(path.substring(0,path.length()-1));
		}
		catch(FileNotFoundException e) {
			System.out.println("file not found");
		}finally {
			if(in!=null) {
				in.close();
			}
		}
	
	}
	public static void recursive(String directory)
	{    
		System.out.print(directory);
		File file1=new File(directory);
		File[] files=file1.listFiles();
		System.out.print(file1.listFiles());
		for(File file:files) {
			if(file.isFile()) {
				System.out.println("Name of file is : "+ file.getName()+"      Path of file is: "+ file.getAbsolutePath());
			}else if(file.isDirectory()){
					recursive(file.getAbsolutePath());
				}
			}
	 }
}


