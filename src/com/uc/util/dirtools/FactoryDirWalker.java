package com.uc.util.dirtools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.DirectoryWalker;

public class FactoryDirWalker extends DirectoryWalker{
	//File f1 = new File("C:\\a\\d\\apps\\7Z\\App\\7-Zip\\");
	//
	
	
	public FactoryDirWalker() {
	      super();
	    }

	    public List clean(File startDirectory) {
	      List results = new ArrayList();
	      try {
			walk(startDirectory, results);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      return results;
	    }

	    protected boolean handleDirectory(File directory, int depth, Collection results) {
	      // delete svn directories and then skip
	      if (".svn".equals(directory.getName())) {
	        directory.delete();
	        return false;
	      } else {
	        return true;
	      }

	    }

	    protected void handleFile(File file, int depth, Collection results) {
	      // delete file and add to list of deleted
	      file.delete();
	      results.add(file);
	    }


}
