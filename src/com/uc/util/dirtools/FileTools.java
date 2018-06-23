package com.uc.util.dirtools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class FileTools {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/*
	 * Apache Commons IO File Routines
	 * 
	 */
	public static void dirPrint() {
		ArrayList<String> as = new ArrayList<String>();
		File f1 = new File("W:\\temp\\");
		//System.out.println(FileUtils.listFilesAndDirs(f1,TrueFileFilter.INSTANCE,TrueFileFilter.INSTANCE));
		//System.out.println(FileUtils.listFilesAndDirs(f1,FalseFileFilter.INSTANCE,TrueFileFilter.INSTANCE));
		//results = FileUtils.listFilesAndDirs(f1,FalseFileFilter.INSTANCE,TrueFileFilter.INSTANCE);
		//System.out.println(results);
		Collection<File> files =  FileUtils.listFilesAndDirs(f1,FalseFileFilter.INSTANCE,TrueFileFilter.INSTANCE);
		for (Iterator i = files.iterator(); i.hasNext();) {
			File file = (File) i.next();
			System.out.println(file.getName() + " - is a dir? " + file.isDirectory());
			as.add(file.getName());
		}
		System.out.println(files);
		System.out.println(as);
		System.out.println(as.get(0));
		
	}
	
	
	public static void copy() {
		try {
			File f1 = new File("sourceDir.txt");
			File f2 = new File("targetDir.txt");

			InputStream in = new FileInputStream(f1);
			OutputStream out = new FileOutputStream(f2);

			//copy byte by byte or byte chunks
			byte[] buf = new byte[1024];
			int len;
			/*
			 * 1.set len = in.read (buffer)
			 * 2.if this len > 0, then
			 * 3.write the buffer from 0 to len <-- 1024 bytes
			 */
			while ( (len = in.read(buf) ) > 0) {
				// write from buf... start[0]... end[len]
				out.write(buf, 0, len);
			}
			// close the streams
			in.close();
			out.close();

			System.out.println("File Copied");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void copyCommonsIo(File f1, File f2) throws IOException {
		//added apache.commons.io.2.6 jar
		FileUtils.copyFile(f1, f2);
		System.out.println("File Copied By Commons.io: " + f2);
	}
	
	private static void FactoryWalkerTest() {
		//FactoryDirWalker fdw = new FactoryDirWalker();
		//results = fdw.clean(f1);
		//System.out.print(results);
	}

}
