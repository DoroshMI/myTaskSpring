package org.dorosh.spring.ch4.method;

import java.io.IOException;
import java.io.File;

import org.dorosh.spring.ch4.SimpleBeanInterface;

public class SimpleBeanWithMethod implements SimpleBeanInterface {

	private String filePath;
	private File file;

	@Override
	public void setFilePath(String filePath){
		this.filePath=filePath;
	}

	@Override
	public void afterPropertiesSet() throws IOException{
		System.out.println("Initializing Bean in "+SimpleBeanWithMethod.class);

		if(filePath==null) {
			throw new IllegalArgumentException("You must set the filePath property of any beans of type"+
				SimpleBeanWithMethod.class);
		}

		this.file=new File(filePath);
		this.file.createNewFile();
		System.out.println("File exists: "+file.exists());
		System.out.println("FilePath: "+filePath);
	}

	@Override
	public void destroy(){
		System.out.println("Destroing Bean in "+SimpleBeanWithMethod.class);
		if(!file.delete()){
			System.err.println("ERROR: failed to delete file.");
		}
		System.out.println("File exists: "+file.exists());
	}
	
}
