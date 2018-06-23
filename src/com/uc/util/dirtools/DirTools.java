package com.uc.util.dirtools;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class DirTools {

	private static String input;
	private static String srcPath = "W:\\w\\temp\\";
	private String srcList = "";
	private String srcFolder = "";
	private static String srcFilename = "readme.txt";
	private static File srcFile = new File("W:\\temp\\");
	private static File srcDir = new File("W:\\temp\\");
	
	
	private String destPath = "";
	private String destList = "";
	private String destFolder = "";
	private static String destFilename ="readme.zip";
	private static File destFile = new File("W:\\temp\\filelist.txt");
	
	
	private static ArrayList<String> fileList = new ArrayList<String>();
	private static String path7z = "C:\\a\\d\\apps\\7Z\\App\\7-Zip\\7z.exe";

	
	
	public static String getCliInput(String message) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print(message);
		String input = sc.nextLine();
		return input;
	}
	
	/*
	 * Directory Methods
	 */
	
	public static void srcDirSet() {
		//Scan input & assign to tempPath
		String pathTemp = getCliInput("Enter Source Path(NO trailing \\!) [srcPath]: ");
		
		//Validate tempPath before assigning to srcPath
		input = getCliInput("Is this path correct?: [" + pathTemp + "]: ");
		srcPath = input.toLowerCase().equals("y") ? pathTemp : srcPath;
		
		System.out.println("srcPath: " + srcPath);
		System.out.println("---------------------------");
	}
	
	public static void srcDirGetListWithSubDirs() {
		System.out.println("srcDirGetListWithSubDirs()");
		Collection<File> files =  FileUtils.listFilesAndDirs(new File(srcPath),FalseFileFilter.INSTANCE,TrueFileFilter.INSTANCE);

		
		//Iterate through files and append to ArrayList<String> fileList
		for (Iterator<File> i = files.iterator(); i.hasNext();) {
			File file = (File) i.next();
			fileList.add(file.getAbsolutePath());
		}
		
		
		// Iterate the ArrayList<String> to verify contents & check for errors
		for (int i = 0; i < fileList.size(); i++) {
			String s = fileList.get(i);
			System.out.println(s);
		}
	}

	public static void srcDirGetListNoSubDir() {
		 File dir = new File(srcPath + "\\.");
		 String[] files = dir.list( DirectoryFileFilter.INSTANCE );
		 fileList.clear();
		 for ( int i = 0; i < files.length; i++ ) {
//		     System.out.println(files[i]);
		     fileList.add(srcPath + "\\" + files[i]);
		 }
		
		// Iterate the ArrayList<String> to verify contents & check for errors
		for (int i = 0; i < fileList.size(); i++) {
			String s = fileList.get(i);
			System.out.println(s);
		}
		System.out.println("---------------------------");
	}
	
	public static void listToFile(Boolean append) {
		System.out.println("listToFile():Exporting FileList to: " + destFile.getAbsolutePath());

		for (int i = 0; i < fileList.size(); i++) {
			String s = fileList.get(i);

			// remove system dirs
			if (s.contains("$")) {
				fileList.remove(i); 			
				System.out.println(s + " : Removed");
			}else{
				System.out.println(s);
			}
		}

		try {
			FileUtils.writeLines(destFile, fileList, append);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("---------------------------");
	}	
	
	

	/*
	 * Basic List Methods
	 */

	public static void listCreate() {
		srcDirSet();
		srcDirGetListNoSubDir();
		listToFile(false);
	}
	public static void listAppend() {
		srcDirSet();
		srcDirGetListNoSubDir();
		listToFile(true);
	}

	

//	----------------PENDING------------------------------
	public static void listOpen() {
		System.out.println("listOpen()");
		fileList.clear();
		// open the listFile & pipe to ArrayList<String>
		try {
			Collection<String> fileCollection = FileUtils.readLines(destFile);
			
			for (Iterator fnames = fileCollection.iterator(); fnames.hasNext();) {
				String fname = (String) fnames.next();
				fileList.add(fname);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < fileList.size(); i++) {
			System.out.println(fileList.get(i));
			
		}
		
		
	}

	public void listShow() {
		//Print contents of the List

	}
	
	public void listWipe() {
		//delete the list file
	}

	public void list2ArrayList() {
		//
	}
//	----------------PENDING------------------------------
	
	
	/*
	 * List Tools/Functions
	 */
	public static void list2Zip() throws IOException {
		//
		//list2ArrayList();
//		Process process = new ProcessBuilder(path7z, "a", srcPath + destFilename, srcPath + srcFilename).start();
		for (Iterator file = fileList.iterator(); file.hasNext();) {
			String fnameAbsolute = (String) file.next();
			String fname = fnameAbsolute.substring(fnameAbsolute.lastIndexOf("\\")+1);
			System.out.println(
					  " [ Program: " + path7z
					+ " ]"
					+ "[ ZipFile: "
					+ fnameAbsolute + ".zip ]"
					+ "[srcPath: "
					+ srcPath+fname
					+ " ]"
					);
			Process process = new ProcessBuilder(path7z, "a", fnameAbsolute + ".zip" , srcPath + fname).start();
		}
		
	}

//	----------------PENDING------------------------------
	public void list2Iso() {
		//
	}
	
	public void list7z() {
		//
	}
	
	public void zip2List() {
		//
	}
//	----------------PENDING------------------------------	
	
	/*
	 * List Management Methods
	 */
//	----------------PENDING------------------------------
	public void listAddItem() {
		//
	}
	
	public void listDeleteItemFirst() {
		//
	}

	public void listDeleteItemLast() {
		//
	}
	
	public void listDeleteItemNum() {
		//
	}
	
	public void listDeleteItemRange() {
		//
	}
//	----------------PENDING------------------------------
	
	
	
	/*
	 * Archive Unpack Tools
	 * 
	 */
//	----------------PENDING------------------------------
	public void unpackIso() {
		//
	}
	
	public void unpackZip() {
		//
	}
	
	public void unpack7z() {
		//
	}	

	public void unpackRar() {
		//
	}
	
	public void unpackTar() {
		//
	}	
	
	public void unpackGz() {
		//
	}	
//	----------------PENDING------------------------------	

	
	public void callExtrnalProgram(String[] args) throws IOException {
		Process process = new ProcessBuilder("C:\\PathToExe\\MyExe.exe","param1","param2").start();
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;

		System.out.printf("Output of running %s is:", Arrays.toString(args));

		while ((line = br.readLine()) != null) {
		  System.out.println(line);
		}
	}

	public static void srcDirGetListSingleLevel() {
		 File dir = new File("W:\\temp\\.");
		 String[] files = dir.list( DirectoryFileFilter.INSTANCE );
		 for ( int i = 0; i < files.length; i++ ) {
		     System.out.println(files[i]);
		     fileList.add(files[i]);
		 }
		 
	}
	
}

